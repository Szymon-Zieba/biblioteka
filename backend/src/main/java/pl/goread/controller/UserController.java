package pl.goread.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.goread.model.User;
import pl.goread.payload.MessageResponse;
import pl.goread.payload.PrivateDataChangeRequest;
import pl.goread.repository.UserRepository;
import pl.goread.service.UserService;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user/{pesel}")
    public User getUserByPesel(@PathVariable String pesel){
        return userRepository.findUserByPESEL(pesel);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        updatedUser.setPassword(userService.getUserById(id).getPassword());
        return userService.updateUser(userService.getUserById(id), updatedUser);
    }

    @PutMapping("/user/{id}/enable")
    public User setEnableAccount(@PathVariable Long id, @RequestParam boolean status) {
        return userService.setEnableAccount(userService.getUserById(id),status);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.delete(userService.getUserById(id));
    }


    @PatchMapping("/user/{id}")
    public ResponseEntity<?> updateUserPrivateData(@PathVariable Long id, @RequestBody PrivateDataChangeRequest privateDataChangeRequest) {
        User user = userService.getUserById(id);

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), privateDataChangeRequest.oldPassword()));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("Nieprawidłowe hasło"));
        }

        user.setPESEL(privateDataChangeRequest.PESEL());

        if (!privateDataChangeRequest.newPassword().equals("")) {
            user.setPassword(passwordEncoder.encode(privateDataChangeRequest.newPassword()));
        }
        userRepository.save(user);
        return ResponseEntity.ok().body(user);
    }
}

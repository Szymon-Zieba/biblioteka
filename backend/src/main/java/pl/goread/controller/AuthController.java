package pl.goread.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.goread.model.User;
import pl.goread.payload.AuthenticationRequest;
import pl.goread.payload.AuthenticationResponse;
import pl.goread.payload.MessageResponse;
import pl.goread.repository.RoleRepository;
import pl.goread.repository.UserRepository;
import pl.goread.security.jwt.JWTUtils;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest request) {
        Authentication authentication;
        try{
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        }catch(AuthenticationException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("Nieprawidłowy email lub hasło"));
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User userPrincipal = (User) authentication.getPrincipal();

        return ResponseEntity.ok(new AuthenticationResponse(
                jwtUtils.generateToken(authentication),
                userPrincipal.getId(),
                userPrincipal.getEmail(),
                userPrincipal.getRole()));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody AuthenticationRequest request) {
        if (userRepository.existsUserByEmail(request.email())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Ten email jest już zajęty."));
        }

        User user = new User(
                request.email(),
                passwordEncoder.encode(request.password())
        );

        user.setRole(roleRepository.findRoleByName("ROLE_USER"));
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("Zarejestrowano pomyślnie!"));
    }

}

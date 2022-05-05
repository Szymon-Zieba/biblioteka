package pl.goread.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import pl.goread.model.Book;
import pl.goread.model.User;
import pl.goread.repository.RoleRepository;
import pl.goread.repository.UserRepository;
import pl.goread.service.UserService;

import java.util.List;



@RestController
@CrossOrigin
@RequiredArgsConstructor
public class EmployeeController
{
    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/employees")
    List<User> getEmployees(){
        return userRepository.getEmployees();
    };

    @GetMapping("/employee/{id}")
    public User getEmployeeById(@PathVariable Long id){
        return userRepository.getEmployeeById(id);
    };
    @PostMapping("/employee")
    public User addEmployee(@RequestBody User user){
        return userService.addEmployee(user);
    };
    @DeleteMapping("/employee/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        userRepository.deleteById(id);
    };

}
package pl.goread.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pl.goread.model.Book;
import pl.goread.model.User;
import pl.goread.repository.UserRepository;
import java.util.List;



@RestController
@RequiredArgsConstructor
public class EmployeeController
{
    private final UserRepository userRepository;

    @GetMapping("/employees")
    List<User> getEmployees(){return userRepository.getEmployees();};

    @GetMapping("/employees/{id}")
    public User getEmployeeById(@PathVariable Long id){return userRepository.getEmployeeById(id);};
}
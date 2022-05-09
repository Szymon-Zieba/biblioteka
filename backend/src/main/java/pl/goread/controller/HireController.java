package pl.goread.controller;

import org.springframework.web.bind.annotation.*;
import pl.goread.model.Book;
import pl.goread.model.Hire;
import pl.goread.model.User;
import pl.goread.repository.HireRepository;
import pl.goread.service.HireService;

public class HireController {

    private HireService hireService;

    private HireRepository hireRepository;


    @GetMapping("/hire/{id}")
    public Hire getHire(@PathVariable Long id){
        return hireService.getHireById(id);
    }

    @PostMapping("/hire")
    public Hire postHire(@RequestBody Hire hire) {
        return hireService.addHire(hire);
    }

}

package pl.goread.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.goread.model.Hire;
import pl.goread.repository.HireRepository;
import pl.goread.service.HireService;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class HireController {
    private final HireService hireService;

    @GetMapping("/hire/{id}")
    public Hire getHire(@PathVariable Long id) {
        return hireService.getHireById(id);
    }

    @PostMapping("/hire")
    public Hire postHire(@RequestBody Hire hire) {
        return hireService.addHire(hire);
    }

    @GetMapping("/hires/user/{id}")
    public List<Hire> getHiresByUserId(@PathVariable Long id) {
        return hireService.getHiresByUserId(id);
    }

    @GetMapping("/hires/library/{id}")
    public List<Hire> getHiresByLibraryId(@PathVariable Long id) {
        return hireService.getHiresByLibraryId(id);
    }


}

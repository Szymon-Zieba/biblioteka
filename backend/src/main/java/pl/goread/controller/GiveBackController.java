package pl.goread.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.goread.model.GiveBack;
import pl.goread.repository.GiveBackRepository;
import pl.goread.service.GiveBackService;

import java.util.List;


@RestController
@CrossOrigin
@RequiredArgsConstructor
public class GiveBackController {
    private final GiveBackRepository giveBackRepository;
    private final GiveBackService giveBackService;


    @GetMapping("/giveback/{id}")
    public GiveBack getGiveBackById(@PathVariable Long id) {
        return giveBackRepository.getById(id);
    }

    @GetMapping("/givebacks/user/{id}")
    public List<GiveBack> getGiveBacksByUserId(@PathVariable Long id) {
        return giveBackRepository.getGiveBacksByUserId(id);
    }

    @PostMapping("/giveback")
    public GiveBack addGiveBack(@RequestBody GiveBack giveBack) {
        return giveBackService.addGiveBack(giveBack);
    }

}

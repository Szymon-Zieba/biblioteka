package pl.goread.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.goread.model.PickUp;
import pl.goread.repository.PickUpRepository;
import pl.goread.service.PickUpService;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class PickUpController {
    private final PickUpRepository pickUpRepository;
    private final PickUpService pickUpService;


    @GetMapping("/pickup/{id}")
    public PickUp getPickUpById(@PathVariable Long id){
        return pickUpRepository.getPickUpByHireId(id);
    };

    @PostMapping("/pickup")
    public PickUp addPickUp(@RequestBody PickUp pickup){
        return pickUpService.addPickup(pickup);
    };

}

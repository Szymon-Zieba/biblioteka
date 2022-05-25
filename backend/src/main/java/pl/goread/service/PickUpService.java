package pl.goread.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.goread.model.Hire;
import pl.goread.model.PickUp;;import java.util.List;

@Service
@RequiredArgsConstructor
public class PickUpService {

    private final pl.goread.repository.PickUpRepository pickUpRepository;


    public PickUp addPickup(PickUp pickup){
        return pickUpRepository.save(pickup);
    };
}

package pl.goread.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.goread.model.PickUp;
import pl.goread.repository.PickUpRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PickUpService {

    private final PickUpRepository pickUpRepository;

    public Optional<PickUp> getPickUpById(Long id){
        return pickUpRepository.findById(id);
    }


}

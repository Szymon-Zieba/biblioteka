package pl.goread.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.goread.model.GiveBack;
import pl.goread.model.Settlement;
import pl.goread.repository.GiveBackRepository;
import pl.goread.repository.SettlementRepository;
import pl.goread.service.GiveBackService;
import pl.goread.service.SettlementService;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class SettlementController {
    private final SettlementRepository settlementRepository;
    private final SettlementService settlementService;

    @GetMapping("/settlement/{id}")
    public Settlement getSettlementById(@PathVariable Long id){
        return settlementRepository.getById(id);
    };

    @PostMapping("/settlement")
    public Settlement addSettlement(@RequestBody Settlement settlement){
        return settlementService.addSettlement(settlement);
    };
}

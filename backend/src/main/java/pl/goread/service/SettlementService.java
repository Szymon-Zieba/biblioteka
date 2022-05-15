package pl.goread.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.goread.model.GiveBack;
import pl.goread.model.Hire;
import pl.goread.model.Settlement;
import pl.goread.repository.SettlementRepository;

@Service
@RequiredArgsConstructor
public class SettlementService {
    private final SettlementRepository settlementRepository;

    public Settlement findSettlementByHire(Hire hire){
        return settlementRepository.findSettlementByHire(hire);
    }

    public Settlement addSettlement(Settlement settlement){
        return settlementRepository.save(settlement);
    };

}

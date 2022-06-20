package pl.goread.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.goread.model.Hire;
import pl.goread.model.Settlement;
import pl.goread.repository.SettlementRepository;

@Service
@RequiredArgsConstructor
public class SettlementService {
    private final SettlementRepository settlementRepository;

    /**
     * Find a settlement by hire.
     *
     * @param hire the hire object that you want to find the settlement for
     * @return A Settlement object
     */
    public Settlement findSettlementByHire(Hire hire) {
        return settlementRepository.findSettlementByHire(hire);
    }

    /**
     * This function adds a settlement to the database.
     *
     * @param settlement The settlement object to be added to the database.
     * @return The settlement object that was saved.
     */
    public Settlement addSettlement(Settlement settlement) {
        return settlementRepository.save(settlement);
    }

    ;

}

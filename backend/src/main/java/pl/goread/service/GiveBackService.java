package pl.goread.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.goread.model.GiveBack;
import pl.goread.model.Hire;
import pl.goread.model.User;
import pl.goread.repository.GiveBackRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GiveBackService {

    private final GiveBackRepository GiveBackRepository;

    /**
     * This function returns a list of give backs by hire.
     *
     * @param hire the hire object that you want to get the givebacks from.
     * @return A list of GiveBack objects.
     */
    public List<GiveBack> getGiveBacksByHire(Hire hire) {
        return GiveBackRepository.getGivesBackByHire(hire);
    }

    /**
     * This function returns a list of givebacks that are associated with a specific employee
     *
     * @param user The user object that you want to get the givebacks for.
     * @return A list of GiveBack objects.
     */
    public List<GiveBack> getGiveBackByEmployee(User user) {
        return GiveBackRepository.getGiveBackByEmployee(user);
    }

    /**
     * This function takes in a GiveBack object and saves it to the database
     *
     * @param giveBack The GiveBack object that you want to add to the database.
     * @return The giveBack object is being returned.
     */
    public GiveBack addGiveBack(GiveBack giveBack) {
        return GiveBackRepository.save(giveBack);
    }
}

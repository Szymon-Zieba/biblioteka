package pl.goread.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.goread.model.Book;
import pl.goread.model.GiveBack;
import pl.goread.model.Hire;
import pl.goread.model.User;
import pl.goread.repository.BookRepository;
import pl.goread.repository.GiveBackRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GiveBackService {

    private final GiveBackRepository GiveBackRepository;

    public List<GiveBack> getGivesBackByHire(Hire hire){
        return GiveBackRepository.getGivesBackByHire(hire);
    }

    public List<GiveBack> getGiveBackByEmployee(User user){
        return GiveBackRepository.getGiveBackByEmployee(user);
    }

}

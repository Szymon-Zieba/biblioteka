package pl.goread.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.goread.model.Hire;
import pl.goread.model.Library;
import pl.goread.model.User;
import pl.goread.repository.HireRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HireService {
    private final HireRepository HireRepository;

    public List<Hire> getHiresByLibrary(Library library){
        return HireRepository.getHiresByLibrary(library);
    }

    public List<Hire> getHiresByUser(User user){
        return HireRepository.getHiresByUser(user);
    }

}

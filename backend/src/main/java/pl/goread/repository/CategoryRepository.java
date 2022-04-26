package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.goread.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}

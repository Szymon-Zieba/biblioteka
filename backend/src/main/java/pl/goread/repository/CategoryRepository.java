package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.goread.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /**
     * Find a category by name.
     *
     * @param name The name of the category.
     * @return A Category object
     */
    Category findByName(String name);

    /**
     * Returns true if a category with the given name exists, false otherwise.
     *
     * @param name The name of the category to check.
     * @return boolean
     */
    boolean existsCategoryByName(String name);
}

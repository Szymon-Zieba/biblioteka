package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.goread.model.PublishmentHouse;

@Repository
public interface PublishmentHouseRepository extends JpaRepository<PublishmentHouse, Long> {

    /**
     * Find a PublishmentHouse by name.
     *
     * @param name the name of the publisher
     * @return A PublishmentHouse object.
     */
    PublishmentHouse findByName(String name);

    /**
     * It checks if a publishment house exists by name.
     *
     * @param name The name of the publisher.
     * @return boolean
     */
    boolean existsPublishmentHouseByName(String name);
}

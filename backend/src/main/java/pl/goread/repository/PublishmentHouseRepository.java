package pl.goread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.goread.model.PublishmentHouse;

@Repository
public interface PublishmentHouseRepository extends JpaRepository<PublishmentHouse, Long> {
     PublishmentHouse findByName(String name);

    boolean existsPublishmentHouseByName(String name);
}

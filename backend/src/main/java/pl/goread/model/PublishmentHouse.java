package pl.goread.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class PublishmentHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

}
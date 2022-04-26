package pl.goread.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Author> author;

    @ManyToOne(fetch = FetchType.LAZY)
    private PublishmentHouse publishmentHouse;
}

package pl.goread.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Author> authors;

    @ManyToOne(fetch = FetchType.LAZY)
    private PublishmentHouse publishmentHouse;
}

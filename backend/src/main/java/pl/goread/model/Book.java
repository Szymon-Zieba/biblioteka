package pl.goread.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Author> author;

    private String publishmentYear;

    @ManyToOne(fetch = FetchType.LAZY)
    private PublishmentHouse publishmentHouse;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    private String description;

    private String imgUrl;
}

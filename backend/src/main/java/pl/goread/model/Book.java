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

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<PublishingHouse> publishingHouse;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Category> category;

    private String description;

    private String imgUrl;
}

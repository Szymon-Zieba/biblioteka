package pl.goread.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Author> author=new HashSet<>();

    private String publishmentYear;

    @ManyToOne()
    private PublishmentHouse publishmentHouse;

    @ManyToOne()
    private Category category;

    private String description;

    private String imgUrl;
}

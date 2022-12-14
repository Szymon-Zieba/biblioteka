package pl.goread.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import pl.goread.model.enums.DemandBookStatus;

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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Author> author=new HashSet<>();

    private String publishmentYear;

    @ManyToOne()
    private PublishmentHouse publishmentHouse;

    @ManyToOne()
    private Category category;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String imgUrl;

    @Enumerated(EnumType.STRING)
    private DemandBookStatus status;

    @ManyToOne()
    private Library library;

}

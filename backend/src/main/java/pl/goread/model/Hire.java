package pl.goread.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Entity
@Data
public class Hire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Book> books;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Library library;

    private LocalDateTime hireDate;
}
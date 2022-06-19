package pl.goread.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import pl.goread.model.enums.DemandBookStatus;

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

    @ManyToOne(fetch = FetchType.EAGER)
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Library library;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime hireDate;

    @Enumerated(EnumType.STRING)
    private DemandBookStatus status;
}
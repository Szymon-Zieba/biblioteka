package pl.goread.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class Return {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Hire hire;

    @ManyToOne(fetch = FetchType.LAZY)
    private User employee;

    private LocalDateTime returnDate;
}

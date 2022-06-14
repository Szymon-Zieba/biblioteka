package pl.goread.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class GiveBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    private Hire hire;

    @ManyToOne()
    private User employee;

    private LocalDateTime returnDate;


}

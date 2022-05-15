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

    @OneToOne(fetch = FetchType.LAZY)
    private Hire hire;

    @ManyToOne(fetch = FetchType.LAZY)
    private User employee;

    private LocalDateTime returnDate;


}

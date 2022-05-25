package pl.goread.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class PickUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private Hire hire;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    private LocalDateTime pickUpDate;
}

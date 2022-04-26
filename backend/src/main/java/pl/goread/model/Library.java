package pl.goread.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Library {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String streetAndNumber;

    private String postCode;

    private String phoneNumber;

    private String email;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<User> users;
}

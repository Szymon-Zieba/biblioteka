package pl.goread.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Hire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long book_id;

    private Long user_id;

    private Long library_id;

    private Date date_hire;
}
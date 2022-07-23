package pl.coderslab.dwarf;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "dwarfs")
public class Dwarf {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private LocalDateTime createdOn;

    private String name;

    @Column(name = "latitude")
    private String lat;
    private String lng;

    private String street;
    private String nearestNumber;

    @Transient
    private long distanceFromPapa;

    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }

}

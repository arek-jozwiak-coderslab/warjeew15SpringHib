package pl.coderslab.dwarfs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "dwarfs")
public class Dwarf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "latitude")
    private String lat;
    private String lng;

    private String street;
    private String nearestNumber;

    @Transient
    private long distanceFromPapa;

}

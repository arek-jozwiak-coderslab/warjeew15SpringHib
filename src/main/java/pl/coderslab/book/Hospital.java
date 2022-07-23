package pl.coderslab.book;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}

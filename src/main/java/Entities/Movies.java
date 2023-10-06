package Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movies", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id", "TITRE"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITRE", length = 50, nullable = false)
    private String titre;

    @Column(name = "REAL", length = 50, nullable = false)
    private String realisateur;

    @Column(name = "DATE", length = 50, nullable = true)
    private int annee;


    @Embedded
    private Cinemas cinemas;

    public Movies(String titre, String realisateur, int annee, Cinemas cinemas) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.annee = annee;
        this.cinemas = cinemas;
    }
}

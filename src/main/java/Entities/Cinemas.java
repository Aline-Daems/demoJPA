package Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @EqualsAndHashCode
public class Cinemas {

    @Column(name = "nom", nullable = false)
    public String nom;
    @Column(name = "address", nullable = true)
    public String address;
}

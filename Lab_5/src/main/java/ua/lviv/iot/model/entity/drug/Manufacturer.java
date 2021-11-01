package ua.lviv.iot.model.entity.drug;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Table(name = "manufacturer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "drug", fetch = FetchType.EAGER)
    private Collection<Drug> drugs;

    public Manufacturer(Integer id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    @Override
    public String toString() {
        return "City {"
                + "id =" + id + ", "
                + "name =" + name + ", "
                + "countryId =" + country.getId()
                + "};" + "\n";
    }
}

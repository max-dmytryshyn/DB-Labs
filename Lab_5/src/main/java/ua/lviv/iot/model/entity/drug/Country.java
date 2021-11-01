package ua.lviv.iot.model.entity.drug;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Table(name = "country")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.EAGER)
    private Collection<Manufacturer> manufacturers;

    public Country(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "City {"
                + "id =" + id + ", "
                + "name =" + name
                + "};" + "\n";
    }
}

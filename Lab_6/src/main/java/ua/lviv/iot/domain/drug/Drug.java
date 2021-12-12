package ua.lviv.iot.domain.drug;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "drug")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id", nullable = false)
    private Manufacturer manufacturer;

    @Override
    public String toString() {
        return "Drug {"
                + "id =" + id + ", "
                + "name =" + name + ", "
                + "price =" + price + ", "
                + "manufacturerId =" + manufacturer.getId()
                + "};" + "\n";
    }
}

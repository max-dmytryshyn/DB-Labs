package ua.lviv.iot.domain.patient;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "hospital")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "address", length = 45, nullable = false)
    private String address;

    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private Collection<Patient> patients;

    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private Collection<DoctorPersonalFile> doctorPersonalFiles;

    public Hospital(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Hospital {"
                + "id =" + id + ", "
                + "name =" + name + ", "
                + "address = " + address
                + "};" + "\n";
    }
}

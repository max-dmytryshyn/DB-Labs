package ua.lviv.iot.model.entity.patient;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

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

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private Collection<Patient> patients;

    @OneToMany(mappedBy = "doctor_personal_file", fetch = FetchType.EAGER)
    private Collection<DoctorPersonalFile> doctorPersonalFiles;

    public Hospital(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "City {"
                + "id =" + id + ", "
                + "name =" + name + ", "
                + "address = " + address
                + "};" + "\n";
    }
}

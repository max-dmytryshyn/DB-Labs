package ua.lviv.iot.model.entity.patient;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "doctor_personal_file")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class DoctorPersonalFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "surname", length = 45, nullable = false)
    private String surname;

    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "id", nullable = false)
    private Hospital hospital;

    @OneToMany(mappedBy = "doctorPersonalFile", fetch = FetchType.LAZY)
    private Collection<Patient> patients;

    @OneToMany(mappedBy = "doctorPersonalFile", fetch = FetchType.LAZY)
    private Collection<DoctorAppointment> doctorAppointments;

    public DoctorPersonalFile(Integer id, String name, String surname, Hospital hospital) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.hospital = hospital;
    }

    @Override
    public String toString() {
        return "Doctor personal file {"
                + "id =" + id + ", "
                + "name =" + name + ", "
                + "surname = " + surname + ", "
                + "hospitalId = " + hospital.getId()
                + "};" + "\n";
    }
}

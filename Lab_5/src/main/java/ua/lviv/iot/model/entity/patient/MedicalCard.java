package ua.lviv.iot.model.entity.patient;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Table(name = "medical_card")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class MedicalCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "surname", length = 45, nullable = false)
    private String surname;

    @Column(name = "birth_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp birthDate;

    @OneToMany(mappedBy = "doctor_appointment", fetch = FetchType.EAGER)
    private Collection<DoctorAppointment> doctorAppointments;

    @OneToMany(mappedBy = "tracker_data", fetch = FetchType.EAGER)
    private Collection<TrackerData> trackerDataCollection;

    public MedicalCard(Integer id, String name, String surname, Timestamp birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "City {"
                + "id =" + id + ", "
                + "name =" + name + ", "
                + "surname = " + surname + ", "
                + "birthDate = " + birthDate
                + "};" + "\n";
    }
}

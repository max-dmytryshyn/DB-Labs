package ua.lviv.iot.domain.patient;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "doctor_appointment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class DoctorAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "recommendation")
    private String recommendation;

    @ManyToOne
    @JoinColumn(name = "doctor_personal_file_id", referencedColumnName = "id", nullable = false)
    private DoctorPersonalFile doctorPersonalFile;

    @ManyToOne
    @JoinColumn(name = "medical_card_id", referencedColumnName = "id", nullable = false)
    private MedicalCard medicalCard;

    @Override
    public String toString() {
        return "Doctor appointment {"
                + "id =" + id + ", "
                + "date =" + date + ", "
                + "recommendation = " + recommendation + ", "
                + "doctorPersonalFileId = " + doctorPersonalFile.getId() + ", "
                + "medicalCardId = " + medicalCard.getId()
                + "};" + "\n";
    }
}

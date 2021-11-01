package ua.lviv.iot.model.entity.patient;

import lombok.*;

import javax.persistence.*;

@Table(name = "patient")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "medical_card_id", referencedColumnName = "id", nullable = false)
    private MedicalCard medicalCard;

    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "id", nullable = false)
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "doctor_personal_file_id", referencedColumnName = "id", nullable = false)
    private DoctorPersonalFile doctorPersonalFile;

    @Override
    public String toString() {
        return "City {"
                + "id =" + id + ", "
                + "medicalCardId =" + medicalCard.getId() + ", "
                + "hospitalId = " + hospital.getId() + ", "
                + "doctorPersonalFileId = " + doctorPersonalFile.getId()
                + "};" + "\n";
    }
}

package ua.lviv.iot.model.entity.patient;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table(name = "tracker_data")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class TrackerData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "systolic_blood_pressure")
    @Size(max = 250)
    private Integer systolicBloodPressure;

    @Column(name = "diastolic_blood_pressure")
    @Size(max = 160)
    private Integer diastolicBloodPressure;

    @Column(name = "heart_rate")
    @Size(max = 250)
    private Integer heartRate;

    @Column(name = "temperature")
    private Double temperature;

    @ManyToOne
    @JoinColumn(name = "medical_card_id", referencedColumnName = "id", nullable = false)
    private MedicalCard medicalCard;

    @Override
    public String toString() {
        return "City {"
                + "id =" + id + ", "
                + "date =" + date + ", "
                + "systolicBloodPressure =" + systolicBloodPressure + ", "
                + "diastolicBloodPressure =" + diastolicBloodPressure + ", "
                + "heartRate =" + heartRate + ", "
                + "temperature =" + temperature + ", "
                + "medicalCardId =" + medicalCard.getId()
                + "};" + "\n";
    }
}

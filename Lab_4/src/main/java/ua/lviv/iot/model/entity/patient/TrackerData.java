package ua.lviv.iot.model.entity.patient;

import lombok.*;
import ua.lviv.iot.model.annotations.NotInputtable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Table(name = "tracker_data")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class TrackerData {
    @Id
    @Column(name = "id")
    @NotInputtable
    private Integer id;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date date;

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

    @Column(name = "medical_card_id")
    @NotNull
    private Integer medicalCardId;

}

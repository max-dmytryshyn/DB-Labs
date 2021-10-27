package ua.lviv.iot.model.entity.patient;

import lombok.*;
import ua.lviv.iot.model.annotations.NotInputtable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "doctor_appointment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class DoctorAppointment {
    @Id
    @Column(name = "id")
    @NotInputtable
    private Integer id;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date date;

    @Column(name = "recommendation")
    private String Recommendation;

    @Column(name = "doctor_personal_file_id")
    @NotNull
    private Integer doctorPersonalFileId;

    @Column(name = "medical_card_id")
    @NotNull
    private Integer medicalCardId;

}

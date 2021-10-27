package ua.lviv.iot.model.entity.patient;

import lombok.*;
import ua.lviv.iot.model.annotations.NotInputtable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "patient")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Patient {
    @Id
    @Column(name = "id")
    @NotInputtable
    private Integer id;

    @Column(name = "medical_card_id")
    @NotNull
    private Integer medicalCardId;

    @Column(name = "hospital_id")
    @NotNull
    private Integer hospitalId;

    @Column(name = "doctor_personal_file_id")
    @NotNull
    private Integer doctorPersonalFileId;
}

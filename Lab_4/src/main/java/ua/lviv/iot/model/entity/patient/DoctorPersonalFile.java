package ua.lviv.iot.model.entity.patient;

import lombok.*;
import ua.lviv.iot.model.annotations.NotInputtable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "doctor_personal_file")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class DoctorPersonalFile {
    @Id
    @Column(name = "id")
    @NotInputtable
    private Integer id;

    @Column(name = "name", length = 45)
    @NotNull
    private String name;

    @Column(name = "surname", length = 45)
    @NotNull
    private String surname;

    @Column(name = "hospital_id")
    @NotNull
    private Integer hospitalId;
}

package ua.lviv.iot.model.entity.patient;

import lombok.*;
import ua.lviv.iot.model.annotations.NotInputtable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "medical_card")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class MedicalCard {
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

    @Column(name = "birth_date")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date birthDate;
}

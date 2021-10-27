package ua.lviv.iot.model.entity.drug;

import lombok.*;
import ua.lviv.iot.model.annotations.NotInputtable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "country")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Country {
    @Id
    @Column(name = "id")
    @NotInputtable
    private Integer id;

    @Column(name = "name", length = 45)
    @NotNull
    private String name;
}

package ua.lviv.iot.dto.patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalCardDto {
    private Integer id;
    private String name;
    private String surname;
    private Timestamp birthDate;
}

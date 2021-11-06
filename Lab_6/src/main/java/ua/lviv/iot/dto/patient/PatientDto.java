package ua.lviv.iot.dto.patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDto {
    private Integer id;
    private String name;
    private String surname;
    private String hospitalName;
    private String doctorName;
    private String doctorSurname;
}

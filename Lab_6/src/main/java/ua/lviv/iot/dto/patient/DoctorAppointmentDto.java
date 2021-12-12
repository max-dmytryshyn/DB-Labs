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
public class DoctorAppointmentDto {
    private Integer id;
    private Timestamp date;
    private String recommendation;
    private String doctorName;
    private String doctorSurname;
    private String patientName;
    private String patientSurname;
}

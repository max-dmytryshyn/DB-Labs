package ua.lviv.iot.dto.drug;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DrugDto {
    private Integer id;
    private String name;
    private Double price;
    private String manufacturerName;
    private String country;
}

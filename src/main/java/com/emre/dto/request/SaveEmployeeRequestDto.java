package com.emre.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveEmployeeRequestDto {

    private Long identityNumber;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String department;
    private Long companyId;
}

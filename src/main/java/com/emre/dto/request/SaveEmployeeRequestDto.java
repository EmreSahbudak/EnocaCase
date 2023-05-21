package com.emre.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveEmployeeRequestDto {


    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[0,2,4,6,8]{1}$", message = "Geçersiz TC Kimlik Numarası")
    private String identityNumber;
    private String name;
    private String surname;
    @Email
    private String email;
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "Telefon numarası geçerli bir formatta olmalıdır.(XXX-XXX-XXXX)")
    private String phone;
    private String department;
    @NotNull
    private Long companyId;
}

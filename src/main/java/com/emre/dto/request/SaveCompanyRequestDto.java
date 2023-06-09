package com.emre.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveCompanyRequestDto {

    @NotEmpty
    private String companyName;
    @Email
    private String email;
    private String address;
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "Telefon numarası geçerli bir formatta olmalıdır.(XXX-XXX-XXXX)")
    private String phone;
    private String companyIndustry;
}

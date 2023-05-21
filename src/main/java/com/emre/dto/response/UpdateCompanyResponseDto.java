package com.emre.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCompanyResponseDto {

    private String companyName;
    private String email;
    private String address;
    private String phone;
    private String companyIndustry;
}

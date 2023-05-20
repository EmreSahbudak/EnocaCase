package com.emre.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveCompanyRequestDto {

    private String companyName;
    //private List<Long> employeeIds;
    private String email;
    private String address;
    private String phone;
    private String companyIndustry;
}

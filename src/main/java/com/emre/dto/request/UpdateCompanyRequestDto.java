package com.emre.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCompanyRequestDto {
    //Dto kullanıldığı için hangi verilerin güncellenebilir olması isteniyorsa burada bırakılır
    //Hangi veriler güncellenemez olması isteniyorsa sadece buradan silinerek, kod üzerinde başka bir değişiklik
    //yapmadan sistem çalışmaya devam eder. Çünkü Mapsturct kullandığım için builder.build'i otomatik yapıyor.

    private Long companyId;
    private String companyName;
    private String email;
    private String address;
    private String phone;
    private String companyIndustry;
}

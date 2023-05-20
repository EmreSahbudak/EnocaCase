package com.emre.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeRequestDto {
    //Dto kullanıldığı için hangi verilerin güncellenebilir olması isteniyorsa burada bırakılır
    //Hangi veriler güncellenemez olması isteniyorsa sadece buradan silinerek, kod üzerinde başka bir değişiklik
    //yapmadan sistem çalışmaya devam eder. Çünkü Mapsturct kullandığım için builder.build'i otomatik yapıyor.

    private Long employeeId;
    private Long identityNumber;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String department;
    private Long companyId;
}

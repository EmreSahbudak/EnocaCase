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
public class UpdateEmployeeRequestDto {
    //Dto kullanıldığı için hangi verilerin güncellenebilir olması isteniyorsa burada bırakılır
    //Hangi veriler güncellenemez olması isteniyorsa sadece buradan silinerek, kod üzerinde başka bir değişiklik
    //yapmadan sistem çalışmaya devam eder. Çünkü Mapsturct kullandığım için builder.build'i otomatik yapıyor.

    @Size(min = 3)
    private String name;
    @Size(min = 2)
    private String surname;
    @Email
    private String email;
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "Telefon numarası geçerli bir formatta olmalıdır.(XXX-XXX-XXXX)")
    private String phone;
    private String department;
    private Long companyId;
}

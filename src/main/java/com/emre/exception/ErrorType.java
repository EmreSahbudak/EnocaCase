package com.emre.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ErrorType {

    COMPANY_NOT_FOUND(2004,"Aradığınız Şirket bulunamadı",HttpStatus.NOT_FOUND),
    COMPANY_DUPLICATE(2005,"Kaydetmek istediğiniz şirket zaten kayıtlı.",HttpStatus.BAD_REQUEST),
    EMPLOYEE_NOT_FOUND(2006,"Aradığınız çalışan bulunamadı",HttpStatus.NOT_FOUND),
    EMPLOYEE_DUPLICATE(2007,"Kaydetmek istediğiniz çalışan zaten kayıtlı.",HttpStatus.BAD_REQUEST),
    DATA_NOT_FOUND(2008,"Aradığınız veri bulunamadı",HttpStatus.NOT_FOUND),

    BAD_REQUEST(4000,"Geçersiz istek yada parametre",HttpStatus.BAD_REQUEST),
    ERROR(9000,"Beklenmeyen bir hata oluştu. Lütfen daha sonra deneyiniz",
            HttpStatus.INTERNAL_SERVER_ERROR);

    int code;

    String message;

    HttpStatus httpStatus;
}

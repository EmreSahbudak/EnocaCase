package com.emre.service;


import com.emre.entity.CompanyEmployee;
import com.emre.exception.CompanyException;
import com.emre.exception.EmployeeException;
import com.emre.exception.ErrorType;
import com.emre.repository.ICompanyEmployeeRepository;
import com.emre.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyEmployeeService extends ServiceManager<CompanyEmployee,Long> {

    private final ICompanyEmployeeRepository companyEmployeeRepository;

    public CompanyEmployeeService(ICompanyEmployeeRepository companyEmployeeRepository) {
        super(companyEmployeeRepository);
        this.companyEmployeeRepository = companyEmployeeRepository;
    }
    public void save(Long companyId, Long employeeId){
        save(CompanyEmployee.builder()
                .companyId(companyId)
                .employeeId(employeeId)
                .build());
    }
    public Boolean delete(Long employeeId){
        Optional<CompanyEmployee> companyEmployee=companyEmployeeRepository.findOptionalByEmployeeId(employeeId);
        if (companyEmployee.isPresent()) {
            deleteById(companyEmployee.get().getId());
            return true;
        }
        throw new EmployeeException(ErrorType.DATA_NOT_FOUND);
    }
    public void deleteAll(Long companyId){
        Optional<List<CompanyEmployee>> companyEmployee=companyEmployeeRepository.findOptionalByCompanyId(companyId);
        if (companyEmployee.isPresent()) {
            companyEmployee.get().forEach(item ->{
                delete(item);
            });
        }
        throw new CompanyException(ErrorType.COMPANY_NOT_FOUND);
    }
}

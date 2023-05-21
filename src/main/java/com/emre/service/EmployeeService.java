package com.emre.service;

import com.emre.dto.request.SaveEmployeeRequestDto;
import com.emre.dto.request.UpdateEmployeeRequestDto;
import com.emre.dto.response.UpdateEmployeeResponseDto;
import com.emre.entity.Employee;
import com.emre.exception.EmployeeException;
import com.emre.exception.ErrorType;
import com.emre.mapper.IEmployeeMapper;
import com.emre.repository.IEmployeeRepository;
import com.emre.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService extends ServiceManager<Employee,Long> {

    private final IEmployeeRepository employeeRepository;
    private final CompanyEmployeeService companyEmployeeService;

    public EmployeeService(IEmployeeRepository employeeRepository, CompanyEmployeeService companyEmployeeService) {
        super(employeeRepository);
        this.employeeRepository = employeeRepository;
        this.companyEmployeeService = companyEmployeeService;
    }
    public Boolean save(SaveEmployeeRequestDto dto){
        Optional<Employee> optionalEmployee=employeeRepository.findOptionalByIdentityNumber(dto.getIdentityNumber());
        if (optionalEmployee.isEmpty()){
            Employee employee=save(IEmployeeMapper.INSTANCE.toEmployee(dto));
            companyEmployeeService.save(dto.getCompanyId(),employee.getEmployeeId());
            return true;
        }
        throw new EmployeeException(ErrorType.EMPLOYEE_DUPLICATE);
    }

    public Boolean delete(Long employeeId){
        Optional<Employee> optionalEmployee=employeeRepository.findOptionalByEmployeeId(employeeId);
        if (optionalEmployee.get().getEmployeeId().equals(employeeId)){
            deleteById(employeeId);
            companyEmployeeService.delete(employeeId);
            return true;
        }
        throw new EmployeeException(ErrorType.EMPLOYEE_NOT_FOUND);
    }

    public UpdateEmployeeResponseDto update(Long employeeId, UpdateEmployeeRequestDto dto){
        Optional<Employee> optionalEmployee=employeeRepository.findOptionalByEmployeeId(employeeId);
        if (optionalEmployee.isPresent()){
            update(IEmployeeMapper.INSTANCE.toUpdateEmployee(dto,optionalEmployee.get()));
            return IEmployeeMapper.INSTANCE.toUpdateEmployeeResponseDto(optionalEmployee.get());
        }
        throw new EmployeeException(ErrorType.EMPLOYEE_NOT_FOUND);
    }
















}

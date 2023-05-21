package com.emre.service;

import com.emre.dto.request.SaveCompanyRequestDto;
import com.emre.dto.request.UpdateCompanyRequestDto;
import com.emre.entity.Company;
import com.emre.exception.CompanyException;
import com.emre.exception.ErrorType;
import com.emre.mapper.ICompanyMapper;
import com.emre.repository.ICompanyRepository;
import com.emre.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService extends ServiceManager<Company,Long> {

    private final ICompanyRepository companyRepository;
    private final CompanyEmployeeService companyEmployeeService;

    public CompanyService(ICompanyRepository companyRepository, CompanyEmployeeService companyEmployeeService) {
        super(companyRepository);
        this.companyRepository = companyRepository;
        this.companyEmployeeService = companyEmployeeService;
    }

    public Company save(SaveCompanyRequestDto dto){
        Company company= save(ICompanyMapper.INSTANCE.toCompany(dto));
        return company;
    }
    public Boolean delete(Long companyId){
        Optional<Company> optionalCompany=companyRepository.findOptionalByCompanyId(companyId);
        if (optionalCompany.get().getCompanyId().equals(companyId)){
            deleteById(companyId);
            companyEmployeeService.deleteAll(companyId);
            return true;
        }
        throw new CompanyException(ErrorType.COMPANY_NOT_FOUND);
    }
    public Boolean update(Long companyId,UpdateCompanyRequestDto dto){
        Optional<Company> optionalCompany=companyRepository.findOptionalByCompanyId(companyId);
        if (optionalCompany.isPresent()) {
            update(ICompanyMapper.INSTANCE.toUpdateCompany(dto,optionalCompany.get()));
            return true;
        }
        throw new CompanyException(ErrorType.COMPANY_NOT_FOUND);
    }





}

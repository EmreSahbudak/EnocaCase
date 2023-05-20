package com.emre.repository;

import com.emre.entity.CompanyEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICompanyEmployeeRepository extends JpaRepository<CompanyEmployee,Long> {

    Optional<CompanyEmployee> findOptionalByEmployeeId(Long employeeId);

    Optional<List<CompanyEmployee>> findOptionalByCompanyId(Long companyId);
}

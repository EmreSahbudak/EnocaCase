package com.emre.repository;

import com.emre.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICompanyRepository  extends JpaRepository<Company,Long> {

    Optional<Company> findOptionalByCompanyId(Long companyId);
}

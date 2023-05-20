package com.emre.repository;

import com.emre.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> findOptionalByIdentityNumber(Long identityNumber);

    Optional<Employee> findOptionalByEmployeeId(Long employeeId);

}

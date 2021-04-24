package com.hidarisoft.testActiveMQ.repository;

import com.hidarisoft.testActiveMQ.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

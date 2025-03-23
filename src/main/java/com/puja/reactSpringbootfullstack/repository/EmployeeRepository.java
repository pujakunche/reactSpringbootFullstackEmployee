package com.puja.reactSpringbootfullstack.repository;
import com.puja.reactSpringbootfullstack.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//   public Employee findByUsername(String username);
}

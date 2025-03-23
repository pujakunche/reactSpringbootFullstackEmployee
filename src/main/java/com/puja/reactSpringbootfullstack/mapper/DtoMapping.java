package com.puja.reactSpringbootfullstack.mapper;

import com.puja.reactSpringbootfullstack.dto.EmployeeDto;
import com.puja.reactSpringbootfullstack.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class DtoMapping {

    public Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setEmail(employeeDto.getEmail());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        System.out.println(employee);
        return employee;
    }

    public EmployeeDto mapToEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        System.out.println(employeeDto);
        return employeeDto;
    }
}

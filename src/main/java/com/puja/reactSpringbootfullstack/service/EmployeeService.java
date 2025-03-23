package com.puja.reactSpringbootfullstack.service;

import com.puja.reactSpringbootfullstack.dto.EmployeeDto;
import com.puja.reactSpringbootfullstack.entity.Employee;
import com.puja.reactSpringbootfullstack.exceptions.ResourceNotFoundException;
import com.puja.reactSpringbootfullstack.mapper.DtoMapping;
import com.puja.reactSpringbootfullstack.mapper.EmployeeMapper;
import com.puja.reactSpringbootfullstack.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DtoMapping dtoMapping;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, DtoMapping dtoMapping) {
        this.employeeRepository = employeeRepository;
        this.dtoMapping = dtoMapping;
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee submitted = EmployeeMapper.mapToEmployee(employeeDto);
        System.out.println(submitted);
        submitted.setId(null);
        Employee saved = employeeRepository.save(submitted);
        System.out.println(saved);
        EmployeeDto something = EmployeeMapper.mapToEmployeeDto(saved);
        System.out.println("something " + something);
    return something;
}

    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = employees.stream()
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
        return employeeDtos;
    }

    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not exist with id: " + employeeId));
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        return employeeDto;
    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {

        Employee existingEmployee = employeeRepository.findById(employeeDto.getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not exist with id: " + employeeDto.getId()));

        existingEmployee.setFirstName(employeeDto.getFirstName());
        existingEmployee.setLastName(employeeDto.getLastName());
        existingEmployee.setEmail(employeeDto.getEmail());

        employeeRepository.save(existingEmployee);
        return EmployeeMapper.mapToEmployeeDto(existingEmployee);
    }

    public void deleteEmployee(Long employeeId) {

        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not exist with id: " + employeeId));

        employeeRepository.deleteById(employeeId);
    }

}
package com.example.salonmanagement.service;

import com.example.salonmanagement.entity.Employee;
import com.example.salonmanagement.exception.ResourceNotFoundException;
import com.example.salonmanagement.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        logger.info("Retrieving all employees");
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        logger.info("Retrieving employee with id: {}", id);
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
    }

    @Override
    @Transactional
    public Employee createEmployee(Employee employee) {
        logger.info("Creating new employee: {}", employee.getFirstName());
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        logger.info("Updating employee with id: {}", id);
        Employee existingEmployee = getEmployeeById(id);
        existingEmployee.setFirstName(employeeDetails.getFirstName());
        existingEmployee.setLastName(employeeDetails.getLastName());
        existingEmployee.setEmail(employeeDetails.getEmail());
        existingEmployee.setPhoneNumber(employeeDetails.getPhoneNumber());
        existingEmployee.setRole(employeeDetails.getRole());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        logger.info("Deleting employee with id: {}", id);
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }
}

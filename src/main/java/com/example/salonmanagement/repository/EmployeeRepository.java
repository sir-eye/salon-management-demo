package com.example.salonmanagement.repository;

import com.example.salonmanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom Query 1: Find all employees by their role
    @Query("SELECT e FROM Employee e WHERE e.role = :role")
    List<Employee> findByRole(@Param("role") String role);

    // Custom Query 2: Count employees for a given salon ID
    @Query("SELECT COUNT(e) FROM Employee e WHERE e.salon.id = :salonId")
    Long countEmployeesBySalonId(@Param("salonId") Long salonId);
}
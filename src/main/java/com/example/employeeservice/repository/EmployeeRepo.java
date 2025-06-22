package com.example.employeeservice.repository;
import com.example.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

     Employee findByEmail(String email);
     Employee findByEmployeeCode(String employeeCode);
     Employee findById(long id);
     boolean deleteByEmployeeCode(String employeeCode);

}

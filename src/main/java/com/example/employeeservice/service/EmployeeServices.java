package com.example.employeeservice.service;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;



@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee saveEmployee(Employee employee){
        Employee saveEmployee =  employeeRepo.save(employee);
        if(saveEmployee == null){
            return null;
        }
        else{
            return saveEmployee;
        }
    }


    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        if (employees.isEmpty()) {
            return Collections.emptyList();
        } else {
            return employees;
        }
    }

    public Employee getEmployeeById(long id) {
        Employee employee = employeeRepo.findById(id);
        if (employee == null) {
            return null;
        } else {
            return employee;
        }
    }


    public Employee getEmployeeByEmail(String email) {
        Employee employee = employeeRepo.findByEmail(email);
        if (employee == null) {
            return null;
        } else {
            return employee;
        }
    }

    public Employee getEmployeeByEmployeeCode(String employeeCode) {
        Employee employee = employeeRepo.findByEmployeeCode(employeeCode);
        if (employee == null) {
            return null;
        } else {
            return employee;
        }
    }
}

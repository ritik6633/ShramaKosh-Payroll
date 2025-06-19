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


}

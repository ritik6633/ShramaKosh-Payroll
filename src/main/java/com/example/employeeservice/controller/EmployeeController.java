package com.example.employeeservice.controller;
import com.example.employeeservice.model.Employee;
import com.example.employeeservice.service.EmployeeServices;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeeServices")
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;

    @PostMapping("/saveEmployee")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee e){
        Employee returnEmployee = employeeServices.saveEmployee(e);
        if(returnEmployee == null){
            return ResponseEntity.badRequest().body("Data Not Saved");
        }
        else{
            return ResponseEntity.ok().body("Data Saved");
        }
    }


}

package com.example.employeeservice.controller;
import com.example.employeeservice.model.CustomEmployeeData;
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

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeServices.getAllEmployees();
        return ResponseEntity.ok().body(employees);
    }


    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(name="id") long id1) {
        Employee employee = employeeServices.getEmployeeById(id1);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(employee);
        }
    }



    @GetMapping("/getEmployeeByEmail/{email}")
    public ResponseEntity<String> getEmployeeByEmail(@PathVariable(name = "email") String email1) {
        String cc = employeeServices.getEmployeeByEmail(email1);
        if (cc == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cc);
        }
    }


    @GetMapping("/getEmployeeByEmployeeCode/{empcode}")
    public ResponseEntity<Employee> getEmployeeByEmployeeCode(@PathVariable (name = "empcode") String empC) {
        Employee employee = employeeServices.getEmployeeByEmployeeCode(empC);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(employee);
        }
    }



}

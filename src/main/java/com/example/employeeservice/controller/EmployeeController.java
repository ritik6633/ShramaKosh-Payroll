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

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeServices.getAllEmployees();
        if (employees.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(employees);
        }
    }

    @GetMapping("/getEmployeeById")
    public ResponseEntity<Employee> getEmployeeById(@RequestParam long id) {
        Employee employee = employeeServices.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(employee);
        }
    }


    @GetMapping("/getEmployeeByEmail")
    public ResponseEntity<Employee> getEmployeeByEmail(@RequestParam String email) {
        Employee employee = employeeServices.getEmployeeByEmail(email);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(employee);
        }
    }

    @GetMapping("/getEmployeeByEmployeeCode")
    public ResponseEntity<Employee> getEmployeeByEmployeeCode(@RequestParam String employeeCode) {
        Employee employee = employeeServices.getEmployeeByEmployeeCode(employeeCode);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(employee);
        }
    }



}

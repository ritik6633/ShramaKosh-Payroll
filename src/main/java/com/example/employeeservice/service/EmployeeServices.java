package com.example.employeeservice.service;
import com.example.employeeservice.model.CustomEmployeeData;
import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;



@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepo employeeRepo;

    //create
    public Employee saveEmployee(Employee employee){
        Employee saveEmployee =  employeeRepo.save(employee);
        if(saveEmployee == null){
            return null;
        }
        else{
            return saveEmployee;
        }
    }


    //read
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        if (employees.isEmpty()) {
            return Collections.emptyList();
        } else {
            return employees;
        }
    }


    //read
    public Employee getEmployeeById(long id) {
        Employee employee = employeeRepo.findById(id);
        if (employee == null) {
            return null;
        } else {
            return employee;
        }
    }


    public String getEmployeeByEmail(String email) {
        Employee employee = employeeRepo.findByEmail(email);
       String s;
        s = employee.getFirstName();
        if (employee == null) {
            return null;
        } else {
            return s;
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

    //update
   public Employee updateEmployeeData(Employee emp){
     Employee a =   getEmployeeByEmployeeCode(emp.getEmployeeCode());
     if(a==null){
         return null;
     }else{
         a.setFirstName(emp.getFirstName());
         a.setLastName(emp.getLastName());
         a.setEmail(emp.getEmail());
         Employee es = saveEmployee(a);
         return es;
     }
    }

    //delete
    public String deleteByEmpCode(String emp){
        boolean b = employeeRepo.deleteByEmployeeCode(emp);
        if(b){
            return "Deleted";
        }else{
            return "Not Deleted";
        }
    }

}

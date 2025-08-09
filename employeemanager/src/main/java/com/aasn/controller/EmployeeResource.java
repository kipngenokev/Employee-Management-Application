package com.aasn.controller;

import com.aasn.model.Employee;
import com.aasn.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/allEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<> (employees, HttpStatus.OK);

    }

    @GetMapping("/findEmployee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable ("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<> (employee, HttpStatus.OK);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addNewEmployee(employee);
        return new ResponseEntity<> (newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<> (updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable ("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<> (HttpStatus.OK);
    }

}

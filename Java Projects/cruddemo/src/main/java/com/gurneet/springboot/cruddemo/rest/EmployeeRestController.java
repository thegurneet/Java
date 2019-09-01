package com.gurneet.springboot.cruddemo.rest;


import com.gurneet.springboot.cruddemo.dao.EmployeeDAO;
import com.gurneet.springboot.cruddemo.entity.Employee;
import com.gurneet.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // quick inject employee dao; (use constructor injection)
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee theEmployee = employeeService.findById(id);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - " + id);
        }
        return theEmployee;
    }


    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        //set id to 0 incase it's passed in.

        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmploye(@PathVariable int id){
        Employee theEmployee = employeeService.findById(id);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - " + id);
        }

        employeeService.deleteById(id);

        return "Deleted employee id - " + id;
    }


}

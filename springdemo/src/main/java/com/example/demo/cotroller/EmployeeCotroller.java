package com.example.demo.cotroller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeCotroller {
    @Autowired
    private EmployeeService service;

    @PostMapping("/addemployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployee(){
        return service.getEmployee();
    }

    @GetMapping("/employee/{id}")
    public Employee findByID(@PathVariable int id){
        return service.getEmployeeById(id);
    }

    //@PostMapping("/update")
    @RequestMapping(value = "/update",
            produces = "application/json",
            method=RequestMethod.PUT)
    public Employee updateEmployee(@RequestBody Employee employee){
        return service.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        return service.deleteEmployee(id);
    }




}

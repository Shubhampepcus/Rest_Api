package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee employee){
        return repository.save(employee);
    }

    public List<Employee> getEmployee(){
        return repository.findAll();
    }

    public Employee getEmployeeById(int id){
        return repository.findById(id).orElse(null);
    }

    public String deleteEmployee(int id){
        repository.deleteById(id);
        return "Employee deleted Successfully" +id;
    }

    public Employee updateEmployee(Employee employee){
        Employee existigEmployee = repository.findById(employee.getId()).orElse(null);
        existigEmployee.setName(employee.getName());
        existigEmployee.setEmail(employee.getEmail());
        existigEmployee.setPhone(employee.getPhone());
        existigEmployee.setAddress(employee.getAddress());
        return repository.save(existigEmployee);
    }
}

package com.employee.manager.service;

import com.employee.manager.exception.UserNotFoundException;
import com.employee.manager.model.Employee;
import com.employee.manager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;

    @Autowired
    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return repo.save(employee);
    }

    public List<Employee> findAllEmployee() {
        return repo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return repo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return repo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id" + id + "was not found!"));
    }

    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }
}

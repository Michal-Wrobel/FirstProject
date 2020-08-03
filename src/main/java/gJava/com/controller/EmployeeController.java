package gJava.com.controller;

import gJava.com.model.Employee;
import gJava.com.service.employee.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;




@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee create(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = employeeService.createEmployee(firstName, lastName);

        return employee;
    }

    @GetMapping(path = "/{id}")
    public Employee readEmployee(@PathVariable UUID id) {

        return this.employeeService.readEmployee(id);

    }

    @GetMapping
    public List<Employee> getAll() {

        return employeeService.getAll();
    }

    @PutMapping()
    public Employee updateEmployee(@RequestBody Employee employee) {
        return this.employeeService.updateEmployee(employee);

    }

    @DeleteMapping()
    public List<Employee> deleteEmployee(@RequestParam UUID id) {
        return this.employeeService.deleteEmployee(id);

    }


}

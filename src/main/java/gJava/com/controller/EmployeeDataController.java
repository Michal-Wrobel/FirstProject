package gJava.com.controller;

import gJava.com.model.Employee;
import gJava.com.model.EmployeeData;
import gJava.com.service.employeeData.EmployeeDataService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/employeeData")
public class EmployeeDataController {
    private final EmployeeDataService employeeDataService;

    public EmployeeDataController(EmployeeDataService employeeDataService) {
        this.employeeDataService = employeeDataService;
    }


    @PostMapping
    public EmployeeData createEmployeeData(@RequestParam UUID employeeId, @RequestParam BigDecimal monthSalary) {

        EmployeeData employeeData = employeeDataService.createEmployeeData(employeeId, monthSalary);

        return employeeData;
    }

    @GetMapping
    public BigDecimal calculateYearlySalary(@RequestParam UUID employeeId) {

      return employeeDataService.calculateYearlySalary(employeeId);
    }


    @GetMapping(path = "/{id}")
    public EmployeeData getEmployeeData(@PathVariable UUID id) {

        System.out.println("-----");
        return this.employeeDataService.readEmployeeData(id);

    }

    @GetMapping
    public List<EmployeeData> getAll() {

        return this.employeeDataService.getAll();
    }


    @PutMapping()
    public EmployeeData updateEmployee(@RequestBody EmployeeData employeeData) {
        employeeDataService.updateEmployeeData(employeeData);

        return this.employeeDataService.updateEmployeeData(employeeData);

    }

}



package gJava.com.controller;

import gJava.com.model.EmployeeData;
import gJava.com.service.employeeData.EmployeeDataService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(path = "/employeeData")
public class EmployeeDataController {
    private final EmployeeDataService employeeDataService;

    public EmployeeDataController(EmployeeDataService employeeDataService) {
        this.employeeDataService = employeeDataService;
    }


    @PostMapping
    public EmployeeData createEmployeeData(@RequestParam String firstName, @RequestParam String lastName
            , @RequestParam BigDecimal monthSalary) {

        EmployeeData employeeData = employeeDataService.createEmployeeData(firstName, lastName, monthSalary);

        return employeeData;

    }


}

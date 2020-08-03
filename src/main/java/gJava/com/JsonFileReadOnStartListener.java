package gJava.com;

import gJava.com.repositories.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class JsonFileReadOnStartListener {
    @Autowired
    EmployeeRepository employeeRepository;
    @PostConstruct
    private void init() {
        System.out.println("---Post construct---");

        employeeRepository.readFromJson();

    }

}

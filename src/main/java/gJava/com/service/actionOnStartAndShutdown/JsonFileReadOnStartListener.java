package gJava.com.service.actionOnStartAndShutdown;

import gJava.com.repositories.employee.EmployeeRepository;
import gJava.com.repositories.employee.EmployeeRepositoryImp;
import gJava.com.repositories.employeeData.EmployeeDataRepository;
import gJava.com.repositories.employeeData.EmployeeDataRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;

@Component
public class JsonFileReadOnStartListener {
    @Autowired
    EmployeeRepositoryImp employeeRepository;
    @Autowired
    EmployeeDataRepositoryImp employeeDataRepository;

    @PostConstruct
    private void init() {
        System.out.println("---Post construct---");

        employeeRepository.loadDatabaseFromFile();
        employeeDataRepository.loadDatabaseFromFile();
    }


}

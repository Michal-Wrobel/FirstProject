package gJava.com.service.actionOnStartAndShutdown;

import gJava.com.model.Employee;
import gJava.com.repositories.employee.EmployeeRepository;
import gJava.com.repositories.employee.EmployeeRepositoryImp;
import gJava.com.repositories.employeeData.EmployeeDataRepository;
import gJava.com.repositories.employeeData.EmployeeDataRepositoryImp;
import gJava.com.service.jsonConverters.EmployeeJsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Component
public class JsonFileReadOnStartListener {
    @Autowired
    EmployeeRepositoryImp employeeRepository;
    @Autowired
    EmployeeDataRepositoryImp employeeDataRepository;

    @PostConstruct
    private void init() {
        System.out.println("---Post construct---");

        //EmployeeJsonConverter employeeJsonConverter = new EmployeeJsonConverter("EmployeeRepositoryImp.json");

        employeeRepository.readFromJson();
        employeeDataRepository.readFromJson();
        //   employeeRepository.loadDatabaseFromFile();
        //  employeeDataRepository.loadDatabaseFromFile();
    }


}

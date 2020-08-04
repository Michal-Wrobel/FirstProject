package gJava.com.service.actionOnStartAndShutdown;

import gJava.com.repositories.employee.EmployeeRepository;
import gJava.com.repositories.employee.EmployeeRepositoryImp;
import gJava.com.repositories.employeeData.EmployeeDataRepository;
import gJava.com.repositories.employeeData.EmployeeDataRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

@Component
public class JsonFileSaveShutdownHook {
    @Autowired
    EmployeeRepositoryImp employeeRepository;
    @Autowired
    EmployeeDataRepositoryImp employeeDataRepository;

    @PreDestroy
    private void saveDataToJson() {
        System.out.println("---PreDestroy---");

        employeeRepository.saveDatabaseToFile();
        employeeDataRepository.saveDatabaseToFile();


       // employeeRepository.saveToJson(employeeRepository.getAll());

  //    employeeDataRepository.saveToJson(employeeDataRepository.getAll());
    }


}

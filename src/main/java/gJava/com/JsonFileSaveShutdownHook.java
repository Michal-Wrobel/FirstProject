package gJava.com;

import gJava.com.repositories.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class JsonFileSaveShutdownHook {
    @Autowired
    EmployeeRepository employeeRepository;

    @PreDestroy
    private void shutdown() {
        System.out.println("---PreDestroy---");

        employeeRepository.saveToJson(employeeRepository.getAll());
    }


}

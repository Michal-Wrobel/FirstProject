package gJava.com.repositories.employee;

import gJava.com.model.Employee;
import gJava.com.repositories.AbstractRepository;
import gJava.com.service.jsonConverters.EmployeeJsonConverter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

//Nauczyc sie wrzucac na githubie

@Repository
//public class EmployeeRepositoryImp extends AbstractRepository<Employee>
public class EmployeeRepositoryImp extends AbstractRepository<Employee>  {
    private List<Employee> employeeList = new ArrayList<>();
    public static final String FILENAME = "Employees.json";
    //TDD- test driven development


    public  String getFILENAME() {
        return FILENAME;
    }
}

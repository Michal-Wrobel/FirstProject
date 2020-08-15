package gJava.com.repositories.employee;

import gJava.com.model.Employee;
import gJava.com.model.SaveReadFromJson;
import gJava.com.repositories.AbstractRepository;
import gJava.com.service.jsonConverters.EmployeeJsonConverter;
import gJava.com.service.jsonConverters.JsonConverter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

//Nauczyc sie wrzucac na githubie

@Repository
//public class EmployeeRepositoryImp extends AbstractRepository<Employee>
public class EmployeeRepositoryImp extends AbstractRepository<Employee> {
    private List<Employee> employeeList = new ArrayList<>();
    public static final String FILENAME = "EmployeeRepositoryImp.json";



    @Override
    public List<Employee> readFromJson() {
        MyConverter myConverter = new MyConverter(FILENAME);

        return this.entityList = myConverter.fromJson().get();
    }


    private class MyConverter extends JsonConverter<List<Employee>> {

        public MyConverter(String FILENAME) {
            super(FILENAME);
        }


    }
}




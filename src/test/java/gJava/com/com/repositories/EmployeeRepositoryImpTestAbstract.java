package gJava.com.com.repositories;


import gJava.com.model.Employee;
import gJava.com.repositories.AbstractRepository;
import gJava.com.repositories.IRepository;
import gJava.com.repositories.employee.EmployeeRepository;
import gJava.com.repositories.employee.EmployeeRepositoryImp;
import gJava.com.repositories.employeeData.EmployeeDataRepository;
import gJava.com.repositories.employeeData.EmployeeDataRepositoryImp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class EmployeeRepositoryImpTestAbstract extends AbstractRepoClassTest<Employee> {

    @Autowired
    EmployeeRepositoryImp employeeRepository;

    @Override
    public Employee getEntity() {
        return new Employee("Michal", "Kowalski");
    }

    @Override
    public IRepository<Employee> getRepository() {
        return employeeRepository;
    }

    @Override
    public Employee createSecondEntity() {
        return new Employee("Ala", "Nowak");
    }
}

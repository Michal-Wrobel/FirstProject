package gJava.com.com.repositories;


import gJava.com.model.Employee;
import gJava.com.repositories.AbstractRepository;
import gJava.com.repositories.employee.EmployeeRepository;
import gJava.com.repositories.employee.EmployeeRepositoryImp;
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
public class EmployeeRepositoryImpTestAbstract {


    @Autowired
    private EmployeeRepositoryImp employeeRepository;
    private Employee employee;

    @Before
    public void setUp() {
        employee = new Employee("Michal", "Michalczewki");
        this.employee = employeeRepository.createEntity(employee);

    }

    @After
    public void tearDown() {
        employeeRepository.removeAll();
    }

    @Test
    public void createEmployeeTest() {
        Employee newEmployee = new Employee(employee.getFirstName(), employee.getLastName());
        Employee createdEmployee = employeeRepository.createEntity(newEmployee);

        Assertions.assertEquals(employee.getFirstName(), createdEmployee.getFirstName());
        Assertions.assertEquals(employee.getCreated(), createdEmployee.getCreated());
        Assertions.assertFalse(employee.getId() == createdEmployee.getId());

        System.out.println();
    }


    @Test
    public void readEmployeeTest() {
        Employee savedEmployee = employeeRepository.readEntity(employee.getId());

        Assertions.assertEquals(employee, savedEmployee);

    }

    @Test
    public void updateEmployeeTest() {
        Employee savedEmployee = employeeRepository.readEntity(employee.getId());

        savedEmployee.setFirstName("Inne Imie");
        employee.setUpdated(LocalDate.of(2020, 03, 05));
        Assertions.assertTrue(employee.getId().equals(savedEmployee.getId()));
        Assertions.assertFalse(employee.getFirstName().equals(employee.getLastName()));
        Assertions.assertFalse(employee.getUpdated().isEqual(savedEmployee.getUpdated()));

    }

    @Test
    public void deleteEmployeeTest() {

        List<Employee> currentList = employeeRepository.deleteEntity(employee.getId());

        int listSize = currentList.stream().filter(x -> x.equals(employee.getId())).collect(Collectors.toList()).size();

        Assertions.assertEquals(0, listSize);

    }


    @Test
    public void saveToJson() {
        List<Employee> listToJson = employeeRepository.getAll();

        employeeRepository.saveToJson(employeeRepository.getAll());

        List<Employee> listFromJson = employeeRepository.readFromJson();

        listToJson.sort(Comparator.comparing(Employee::getFirstName).reversed());
        listFromJson.sort(Comparator.comparing(Employee::getFirstName).reversed());

        Assertions.assertEquals(listFromJson, listToJson);
        Assertions.assertEquals(listFromJson.size(), listFromJson.size());

    }

    @Test
    public void readFromJson()
    {
        List<Employee> listToJson = employeeRepository.getAll();

        employeeRepository.saveToJson(employeeRepository.getAll());

        List<Employee> listFromJson = employeeRepository.readFromJson();

        listToJson.sort(Comparator.comparing(Employee::getFirstName).reversed());
        listFromJson.sort(Comparator.comparing(Employee::getFirstName).reversed());

        Assertions.assertEquals(listFromJson, listToJson);
        Assertions.assertEquals(listFromJson.size(), listFromJson.size());
    }


}

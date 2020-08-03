package gJava.com.com.repositories;

import gJava.com.model.Employee;
import gJava.com.repositories.employee.EmployeeRepositoryImp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.Assertions;

//ZROB RESZTE METOD W EMPLOYEE ORAZ TESTY

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class EmployeeRepositoryImpTest {
    // UMIESC REGULATORY DOSTEPU
    @Autowired
    private EmployeeRepositoryImp employeeRepository;
    private Employee employee;

    @Before
    public void setUp() {

        employee = new Employee("Michal", "Michalczewki");
        //  employeeRepository.createEmployee(employee);

        this.employee = employeeRepository.createEmployee(employee);
    }

    @After
    public void tearDown() {
        employeeRepository.removeAll();

    }


    @Test
    public void createEmployee() {


        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee("Ala", "Wasacz");
            Employee expectedEmployee = employeeRepository.createEmployee(employee);
        }


        employee.setFirstName("Dupa");


        //  Assertions.assertEquals(employee.getFirstName(), expectedEmployee.getFirstName());
        //  Assertions.assertEquals(employee.getLastName(), expectedEmployee.getLastName());


    }

    @Test
    public void readEmployee() {


        var actualEmployeeId = employee.getId();


        Employee actualEmployee = employeeRepository.readEmployee(actualEmployeeId);


//        Assertions.assertEquals(employee.getFirstName(), actualEmployee.getFirstName());
//        Assertions.assertEquals(employee.getLastName(), actualEmployee.getLastName());

    }

    @Test
    public void updateEmployee() {

        Employee actualEmployee = employeeRepository.updateEmployee(employee);
        employee.setUpdated(LocalDate.of(2020, 04, 20));

//        Assertions.assertEquals(employee.getId(), actualEmployee.getId());
//        Assertions.assertEquals(employee.getFirstName(), actualEmployee.getFirstName());
//        Assertions.assertEquals(employee.getLastName(), actualEmployee.getLastName());
//        Assertions.assertFalse(employee.getUpdated().isEqual(actualEmployee.getUpdated()));
//        Assertions.assertTrue(employee.getCreated().isEqual(actualEmployee.getCreated()));
    }

    @Test
    public void deleteEmployee() {


        List<Employee> actualList = employeeRepository.deleteEmployee(employee.getId());

        Long listSize = actualList.stream().filter(x -> x.getId().equals(employee.getId())).count();

        //  Assertions.assertEquals(listSize, 0);

    }


    @Test
    public void saveToJson() {

        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee("Ala", "Wasacz");
            Employee expectedEmployee = employeeRepository.createEmployee(employee);
        }
        List<Employee> employeesToFile = employeeRepository.getAll();
        employeeRepository.saveToJson(employeesToFile);


        List<Employee> employeesFromFile=employeeRepository.readFromJson();

        Assertions.assertEquals(employeesToFile.size(), employeesFromFile.size());




      //  Assertions.assertThat(employeesToFile.size(),equalTo( employeesFromFile.size()) )


    }
}
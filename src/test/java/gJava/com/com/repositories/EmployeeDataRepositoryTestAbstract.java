package gJava.com.com.repositories;

import gJava.com.model.Employee;
import gJava.com.model.EmployeeData;
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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class EmployeeDataRepositoryTestAbstract {

    @Autowired
    private EmployeeDataRepositoryImp employeeDataRepository;
    private EmployeeData employeeData;

    @Before
    public void setUp() {

        employeeData = new EmployeeData(BigDecimal.valueOf(5000));
        this.employeeData = employeeDataRepository.createEntity(employeeData);

    }

    @After
    public void tearDown() {
        employeeDataRepository.removeAll();
    }

    @Test
    public void createEmployeeDataTest() {
        EmployeeData newEmployeeData = new EmployeeData(BigDecimal.valueOf(5000));

        Assertions.assertEquals(employeeData.getMonthSalary(), newEmployeeData.getMonthSalary());

        System.out.println(newEmployeeData.getId());
        System.out.println(employeeData.getId());

        Assertions.assertNotEquals(newEmployeeData.getId(), employeeData.getId());

    }

    @Test
    public void readEmployeeDataTest() {

        EmployeeData newEmployeeData = employeeDataRepository.readEntity(employeeData.getId());
        Assertions.assertEquals(newEmployeeData, employeeData);

    }

    @Test
    public void updateEmployDataTest() {
        EmployeeData newEmployeeData = employeeDataRepository.readEntity(employeeData.getId());
        newEmployeeData.setUpdated(LocalDate.of(2020, 04, 30));
        newEmployeeData.setMonthSalary(BigDecimal.valueOf(10000));

        employeeDataRepository.updateEntity(employeeData);

        Assertions.assertEquals(employeeData.getId(), newEmployeeData.getId());
        Assertions.assertNotEquals(employeeData.getMonthSalary(), newEmployeeData.getMonthSalary());
        Assertions.assertNotEquals(employeeData.getUpdated(), newEmployeeData.getUpdated());
    }

    @Test
    public void deleteEmployeeDataTest() {
     employeeDataRepository.deleteEntity(employeeData.getId());

        List<EmployeeData> currentList = employeeDataRepository.getAll();

        int numberOfGivenElements = (int) currentList.stream().filter(x -> x.equals(employeeData.getId())).count();

       Assertions.assertEquals(numberOfGivenElements, 0);


    }


}

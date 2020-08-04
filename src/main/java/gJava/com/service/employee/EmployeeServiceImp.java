package gJava.com.service.employee;

import gJava.com.model.Employee;
import gJava.com.repositories.employee.EmployeeRepository;
import gJava.com.repositories.employee.EmployeeRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
// dokonczyc metody restowe i sprawdzic czy dzialaja
//dopisac testy mockito do servisow
//zrefaktoryzowac testy repo zeby uzywaly springa


@Service
public class EmployeeServiceImp implements EmployeeService {
   // private final EmployeeRepository employeeRepository;
@Autowired
   EmployeeRepositoryImp employeeRepository;

//    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }


    @Override
    public Employee createEmployee(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("Both first and last name cannot be null!");
        }

        Employee newEmployee = new Employee(firstName, lastName);

        return this.employeeRepository.createEntity(newEmployee);

    }

    @Override
    public Employee readEmployee(UUID id) {

        return this.employeeRepository.readEntity(id);

    }

    @Override
    public List<Employee> getAll() {

        return this.employeeRepository.getAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return this.employeeRepository.updateEntity(employee);

    }

    @Override
    public List<Employee> deleteEmployee(UUID id) {
        return this.employeeRepository.deleteEntity(id);
    }


}

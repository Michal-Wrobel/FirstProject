package gJava.com.service.employee;


import gJava.com.model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    Employee createEmployee(String firstName, String lastName);

    Employee readEmployee(UUID id);

    List<Employee> getAll();

    Employee updateEmployee(Employee employee);

    List<Employee> deleteEmployee(UUID id);



}

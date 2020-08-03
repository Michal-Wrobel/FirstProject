package gJava.com.repositories.employee;


import gJava.com.model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeRepository {

     Employee createEmployee(Employee employee);

    Employee readEmployee(UUID id);

    List<Employee> getAll();

    Employee updateEmployee(Employee employee);

    List<Employee> deleteEmployee(UUID id);

    List<Employee> removeAll();

    void saveToJson(List<Employee> employees);

    List<Employee>  readFromJson();

}

package gJava.com.repositories.employee;

import gJava.com.model.Employee;
import gJava.com.jsonConverters.EmployeeJsonConverter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

//Nauczyc sie wrzucac na githubie
@Repository

public class EmployeeRepositoryImp implements EmployeeRepository {
    private List<Employee> employeeList = new ArrayList<>();
    public static final String FILENAME = "Employees.json";
    //TDD- test driven development


    @Override
    public Employee createEmployee(Employee employee) {

        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        if (employee.getId() != null) {
            throw new IllegalArgumentException("Employee cannot have id");
        }


        UUID uuid = UUID.randomUUID();
        employee.setId(uuid);

        employeeList.add(employee);

        Employee savedEmployee = employeeList.stream()
                .filter(x -> x.getId().equals(uuid))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Employee id cannot be find"));


        return new Employee(savedEmployee.getId(), savedEmployee.getFirstName(), savedEmployee.getLastName(), LocalDate.now(), LocalDate.now());
    }

    @Override
    public Employee readEmployee(UUID id) {

        Employee savedEmployee = employeeList.stream()
                .filter(x -> x.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Employee id cannot be find"));

        return new Employee(savedEmployee.getId(), savedEmployee.getFirstName(), savedEmployee.getLastName(), savedEmployee.getCreated(), savedEmployee.getUpdated());

    }

    @Override
    public List<Employee> getAll() {

        return employeeList.stream()
                .map(employee -> new Employee(employee.getId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getCreated(), employee.getUpdated()))
                .collect(Collectors.toList());


    }

    @Override
    public Employee updateEmployee(Employee employee) {

        Employee savedEmployee = employeeList.stream()
                .filter(x -> x.getId().equals(employee.getId()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Employee id cannot be find"));


        savedEmployee.setFirstName(employee.getFirstName());
        savedEmployee.setLastName(employee.getLastName());
        savedEmployee.setUpdated(LocalDate.now());

        return new Employee(savedEmployee.getId(), savedEmployee.getFirstName(), savedEmployee.getLastName(), savedEmployee.getCreated(), LocalDate.now());


    }

    @Override
    public List<Employee> deleteEmployee(UUID id) {

        Employee savedEmployee = employeeList.stream()
                .filter(x -> x.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Employee id cannot be find"));

        employeeList.remove(savedEmployee);

        return employeeList;

    }

    @Override
    public List<Employee> removeAll() {
        employeeList.clear();
        List<Employee> emptyList = employeeList;

        return emptyList;

    }


    @Override
    public void saveToJson(List<Employee> employees) {

        EmployeeJsonConverter employeeJsonConverter = new EmployeeJsonConverter(FILENAME);


        employeeJsonConverter.toJson(employees);
    }

    @Override
    public List<Employee> readFromJson() {

        EmployeeJsonConverter employeeJsonConverter = new EmployeeJsonConverter(FILENAME);
        //TODO tego clear nie jsetem pewny ale chyba logiczne :)
        employeeList.clear();
        List<Employee> jsonEmployees = employeeJsonConverter.fromJson().orElseThrow(() -> new IllegalArgumentException(" Cannot parse to json "));


        for (int i = 0; i < jsonEmployees.size(); i++) {

            employeeList.add(jsonEmployees.get(i));
        }

        return employeeJsonConverter.fromJson().orElseThrow(() -> new IllegalArgumentException(" Cannot parse to json "));

    }


}

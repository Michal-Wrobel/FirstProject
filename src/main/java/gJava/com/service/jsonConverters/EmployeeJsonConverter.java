package gJava.com.service.jsonConverters;

import gJava.com.model.Employee;

import java.util.List;

public class EmployeeJsonConverter extends JsonConverter<List<Employee>> {
    public EmployeeJsonConverter(String filename) {
        super(filename);
    }
}

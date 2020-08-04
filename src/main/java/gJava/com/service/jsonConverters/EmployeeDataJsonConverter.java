package gJava.com.service.jsonConverters;

import gJava.com.model.EmployeeData;

import java.util.List;

public class EmployeeDataJsonConverter extends JsonConverter<List<EmployeeData>> {
    public EmployeeDataJsonConverter(String filename) {
        super(filename);
    }
}

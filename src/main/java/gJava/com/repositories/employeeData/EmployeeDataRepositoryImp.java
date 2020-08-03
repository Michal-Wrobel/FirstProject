package gJava.com.repositories.employeeData;

import gJava.com.model.EmployeeData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDataRepositoryImp implements EmployeeDataRepository {
    private List<EmployeeData> employeeDataList = new ArrayList<>();
    public  static final String FILENAME = "Employees.json";


    @Override
    public EmployeeData createEmployeeData(EmployeeData employeeData) {


       employeeDataList.add(employeeData);

       return employeeData;
    }
}

package gJava.com.service.employeeData;


import gJava.com.model.EmployeeData;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface EmployeeDataService {

    EmployeeData createEmployeeData(UUID employeeId,  BigDecimal monthSalary);

    //
    EmployeeData readEmployeeData(UUID id);

    //
    List<EmployeeData> getAll();

    //
    EmployeeData updateEmployeeData(EmployeeData employeeData);

    List<EmployeeData> deleteEmployeeData(UUID id);

    BigDecimal calculateYearlySalary(UUID employeeId);


}

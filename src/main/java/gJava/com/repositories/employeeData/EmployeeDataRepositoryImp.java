package gJava.com.repositories.employeeData;

import gJava.com.repositories.AbstractRepository;
import gJava.com.service.jsonConverters.EmployeeDataJsonConverter;
import gJava.com.model.EmployeeData;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class EmployeeDataRepositoryImp extends AbstractRepository<EmployeeData> {
    private List<EmployeeData> employeeDataList = new ArrayList<>();
    public static final String FILENAME = "EmployeesData.json";

    @Override
    public EmployeeData createEntity(EmployeeData employeeData) {

        EmployeeData newEmployeeData = super.createEntity(employeeData);
        newEmployeeData.setEmployeeID(UUID.randomUUID());
        newEmployeeData.setMonthSalary(employeeData.getMonthSalary());
        return newEmployeeData;
    }


    public  String getFILENAME() {
        return FILENAME;
    }
}
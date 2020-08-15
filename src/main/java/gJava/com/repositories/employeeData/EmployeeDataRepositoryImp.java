package gJava.com.repositories.employeeData;

import gJava.com.model.Employee;
import gJava.com.repositories.AbstractRepository;
import gJava.com.repositories.employee.EmployeeRepositoryImp;
import gJava.com.service.jsonConverters.EmployeeDataJsonConverter;
import gJava.com.model.EmployeeData;
import gJava.com.service.jsonConverters.JsonConverter;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class EmployeeDataRepositoryImp extends AbstractRepository<EmployeeData> {
    private List<EmployeeData> employeeDataList = new ArrayList<>();
    public static final String FILENAME = "EmployeeDataRepositoryImp.json";

    public BigDecimal calculateYearlySalary(UUID employeeId) {

   EmployeeData savedEmployeeData=  entityList.stream().filter(x->x.getEmployeeID().equals(employeeId))
                .findAny()
                .orElseThrow(()->new IllegalArgumentException("No such employee ID"));


        return savedEmployeeData.getMonthSalary().multiply(BigDecimal.valueOf(12));
    }


    @Override
    public EmployeeData createEntity(EmployeeData employeeData) {

        EmployeeData newEmployeeData = super.createEntity(employeeData);
        newEmployeeData.setEmployeeID(UUID.randomUUID());
        newEmployeeData.setMonthSalary(employeeData.getMonthSalary());
        return newEmployeeData;
    }


    @Override
    public void saveToJson(List<EmployeeData> Entitys) {


        MyConverter myConverter = new MyConverter(FILENAME);
        myConverter.toJson(entityList);

    }

    @Override
    public List<EmployeeData> readFromJson() {
        MyConverter myConverter = new MyConverter(FILENAME);

        return  this.entityList= myConverter.fromJson().get();
    }


    private class MyConverter extends JsonConverter<List<EmployeeData>> {

        public MyConverter(String FILENAME) {
            super(FILENAME);
        }

    }


}
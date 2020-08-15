package gJava.com.service.employeeData;

import gJava.com.model.EmployeeData;
import gJava.com.repositories.employeeData.EmployeeDataRepository;
import gJava.com.repositories.employeeData.EmployeeDataRepositoryImp;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
// dokonczyc metody restowe i sprawdzic czy dzialaja
//dopisac testy mockito do servisow
//zrefaktoryzowac testy repo zeby uzywaly springa


@Service
public class EmployeeDataServiceImp implements EmployeeDataService {

    private final EmployeeDataRepositoryImp employeeDataRepository;

    public EmployeeDataServiceImp(EmployeeDataRepositoryImp employeeDataRepository) {
        this.employeeDataRepository = employeeDataRepository;
    }

    //
//
    @Override
    public EmployeeData createEmployeeData(UUID employeeId, BigDecimal monthSalary) {

        EmployeeData employeeData = new EmployeeData(employeeId, monthSalary);

        return this.employeeDataRepository.createEntity(employeeData);

    }


    @Override
    public EmployeeData readEmployeeData(UUID id) {

        return this.employeeDataRepository.readEntity(id);

    }

    //
    @Override
    public List<EmployeeData> getAll() {
        return this.employeeDataRepository.getAll();

    }

    //
    @Override
    public EmployeeData updateEmployeeData(EmployeeData employeeData) {
        return this.employeeDataRepository.updateEntity(employeeData);
    }

    @Override
    public List<EmployeeData> deleteEmployeeData(UUID id) {
        return this.employeeDataRepository.deleteEntity(id);
    }

    @Override
    public BigDecimal calculateYearlySalary(UUID employeeId) {
        return  this.employeeDataRepository.calculateYearlySalary(employeeId);
    }


}

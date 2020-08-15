package gJava.com.com.repositories;


import gJava.com.model.EmployeeData;
import gJava.com.repositories.IRepository;
import gJava.com.repositories.employeeData.EmployeeDataRepositoryImp;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class EmployeeDataRepositoryTestAbstract extends AbstractRepoClassTest<EmployeeData> {

    @Autowired
    private EmployeeDataRepositoryImp employeeDataRepository;
    private EmployeeData employeeData;

    @Override
    public EmployeeData getEntity() {
        return null;
    }

    @Override
    public IRepository<EmployeeData> getRepository() {
        return null;
    }

    @Override
    public EmployeeData createSecondEntity() {
        return null;
    }
}

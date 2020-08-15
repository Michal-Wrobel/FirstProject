package gJava.com.com.repositories;

import gJava.com.model.Identifable;
import gJava.com.model.TimeStampEdpcd;
import gJava.com.repositories.IRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public abstract class AbstractRepoClassTest<Entity extends Identifable & TimeStampEdpcd> {

    private Entity entity; //Musi miec encje- przejmie ja
    private IRepository<Entity> iRepository; //Musi miec repozytory ( i zwiazana z tym liste encji
    // - w przypadku tego projektu - przejmie ja


    public abstract Entity getEntity(); //metoda zeby znalesc typ encji - dlatego abstrakcyjna

    public abstract IRepository<Entity> getRepository(); //metoda zeby znalesc typ typ repozytorium - dlatego abstrakcyjna

    public abstract Entity createSecondEntity(); //Dodatkowa metoda ktorej potrzebuje do updatu

    @Before
    public void setup() {
        this.entity = getEntity();  //Przejmuje type encji z klasy implementujacej
        this.iRepository = getRepository(); //Przejmuje typ repozytorium z klasy implementujacej
    }

    @After
    public void tearDown() {
        iRepository.removeAll();
    }

    @Test
    public void createEntityTest() {
        Entity createdEntity = iRepository.createEntity(entity); //iRepository jest tu juz implementacja EMployRepositoryImp

        List<Entity> entityList = iRepository.getAll();   //I ma jego metody dostosowane do np <Employee>

        UUID savedID = createdEntity.getId();

        Assertions.assertEquals(entityList.size(), 1);
        Assertions.assertEquals(entityList.get(0).getId(), savedID);
    }

    @Test
    public void readEntityTest() {
        Entity createdEntity = iRepository.createEntity(entity);
        List<Entity> entityList = iRepository.getAll();
        UUID savedID = createdEntity.getId();

        Entity foundEntity = entityList.stream().filter(x -> x.getId().equals(savedID))
                .findAny()
                .get();
        Assertions.assertEquals(foundEntity, createdEntity);
    }

    @Test
    public void updateEntityTest() {
        iRepository.createEntity(entity);
        List<Entity> entityList = iRepository.getAll();

        Entity createdEntity = entityList.get(0);
        Entity secondEntity = this.createSecondEntity();

        secondEntity.setId(createdEntity.getId());
        Entity updatedEntity = iRepository.updateEntity(secondEntity);

        Assertions.assertEquals(secondEntity, updatedEntity);
    }

    ;

    @Test
    public void deleteEntityTest() {
        Entity createdEntity = iRepository.createEntity(entity);

        UUID savedID = createdEntity.getId();

        this.iRepository.deleteEntity(savedID);

        List<Entity> all = iRepository.getAll();

        Assertions.assertTrue(all.isEmpty());

    }
    @Test
    public void saveAndLoadToJsonTest() {
        iRepository.createEntity(entity);
        List<Entity> entityList = iRepository.getAll();

        iRepository.saveToJson(entityList);

        List<Entity> entities = iRepository.readFromJson();

        Assertions.assertEquals(entityList.get(0),entities.get(0));
    }
}

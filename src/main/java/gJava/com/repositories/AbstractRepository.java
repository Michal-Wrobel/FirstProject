package gJava.com.repositories;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import gJava.com.model.Employee;
import gJava.com.model.Identifable;
import gJava.com.model.TimeStampEdpcd;
import gJava.com.repositories.employee.EmployeeRepository;
import gJava.com.service.jsonConverters.EmployeeJsonConverter;
import gJava.com.service.jsonConverters.JsonConverter;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import javax.swing.text.html.parser.Entity;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//PODSTAWOWA  teoria interfacy, Abstrakycjne klasy, dziedziczenie itp, po co sa testy, equals i hashcode ( ogolnie core java) testy integracyjne

public abstract class AbstractRepository<Entity extends Identifable & TimeStampEdpcd> implements IRepository<Entity> {
    private List<Entity> entityList = new ArrayList<>();
    @Autowired
    Gson gson;

    public AbstractRepository() {
    }

    @Override
    public Entity createEntity(Entity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        if (entity.getId() != null) {
            throw new IllegalArgumentException("Employee cannot have id");
        }

        UUID uuid = UUID.randomUUID();
        entity.setId(uuid);

        entityList.add(entity);

// Zapis i strzytanie z Jsona
        String s = gson.toJson(entity);
        Entity entityCopy = gson.fromJson(s, (Type) entity.getClass());

        return entity;
    }

    @Override
    public Entity readEntity(UUID id) {
        Entity entity = entityList.stream()
                .filter(x -> x.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Employee id cannot be find"));
        String s = gson.toJson(entity);

        return gson.fromJson(s, (Type) entity.getClass());
    }

    @Override
    public List<Entity> getAll() {

        List<Entity> listCopy = List.copyOf(entityList);


        return listCopy;
    }

    @Override
    public Entity updateEntity(Entity entity) {
// Zrob se z tego notatke poki rozmumiesz
        String s = gson.toJson(entity);

        Entity copy = gson.fromJson(s, (Type) entity.getClass());
        copy.setUpdated(LocalDate.now());

        this.deleteEntity(entity.getId());
        entityList.add(copy);

        String s2 = gson.toJson(entity);

        return gson.fromJson(s2, (Type) entity.getClass());

    }

    @Override
    public List<Entity> deleteEntity(UUID id) {


        Entity savedEntity = entityList.stream()
                .filter(x -> x.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Employee id cannot be find"));

        entityList.remove(savedEntity);

        return entityList;

    }

    @Override
    public List<Entity> removeAll() {
        entityList.clear();
        List<Entity> emptyList = entityList;

        return emptyList;
    }

    @Override
    public void saveToJson(List<Entity> Entitys) {

        String FILENAME = this.getClass().getSimpleName().concat(".json");

        File file = new File(FILENAME);

        saveDatabaseToFile();
    }

    @Override
    public List<Entity> readFromJson() {
        String FILENAME = this.getClass().getSimpleName().concat(".json");

        File file = new File(FILENAME);


        return loadDatabaseFromFile();

    }


    public void saveDatabaseToFile() {
        try {
            FileUtils.writeStringToFile(new File(this.getClass().getSimpleName() + ".json"), gson.toJson(entityList));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //@FIXME use generic
    public List<Entity> loadDatabaseFromFile() {
      //  List<Entity> entities = new ArrayList<>();
        File file = new File(this.getClass().getSimpleName() + ".json");
        if (file == null) {
            throw new IllegalArgumentException();
        }
        try {
            String s = FileUtils.readFileToString(file);
            entityList = gson.fromJson(s, new TypeToken<List<Entity>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return entityList;

    }
}

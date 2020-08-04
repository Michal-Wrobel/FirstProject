package gJava.com.repositories;

import java.util.List;
import java.util.UUID;

public interface IRepository<Entity> {

    Entity createEntity(Entity Entity);

    Entity readEntity(UUID id);

    List<Entity> getAll();

    Entity updateEntity(Entity Entity);

    List<Entity> deleteEntity(UUID id);

    List<Entity> removeAll();

    void saveToJson(List<Entity> Entitys);

    List<Entity>  readFromJson();




}

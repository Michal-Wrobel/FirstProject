package gJava.com.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Employee {

    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate created;
    private LocalDate updated;

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.created=LocalDate.now();
        this.updated=LocalDate.now();
    }

    public Employee(UUID id, String firstName, String lastName, LocalDate created, LocalDate updated) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = created;
        this.updated = updated;
    }






    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(created, employee.created) &&
                Objects.equals(updated, employee.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, created, updated);
    }
//
}

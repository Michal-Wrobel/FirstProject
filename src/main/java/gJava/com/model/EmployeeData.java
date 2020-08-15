package gJava.com.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class EmployeeData implements Identifable, TimeStampEdpcd {
    private UUID id;
    private UUID employeeID;
    private BigDecimal monthSalary;
    private LocalDate created;
    private LocalDate updated;


    public EmployeeData() {
    }

//    public EmployeeData(BigDecimal monthSalary) {
//        this.monthSalary = monthSalary;
//        this.created = LocalDate.now();
//        this.updated = LocalDate.now();
//
//    }

    public EmployeeData(UUID employeeID, BigDecimal monthSalary) {
        this.employeeID = employeeID;
        this.monthSalary = monthSalary;
        this.id = UUID.randomUUID();
        this.created = LocalDate.now();
        this.updated = LocalDate.now();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;

    }

    @Override
    public void setUpdated(LocalDate localDate) {
        this.updated = localDate;
    }

    @Override
    public LocalDate getUpdated() {
        return this.updated;
    }

    public UUID getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(UUID employeeID) {
        this.employeeID = employeeID;
    }

    public BigDecimal getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(BigDecimal monthSalary) {
        this.monthSalary = monthSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeData that = (EmployeeData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(employeeID, that.employeeID) &&
                Objects.equals(monthSalary, that.monthSalary) &&
                Objects.equals(created, that.created) &&
                Objects.equals(updated, that.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeID, monthSalary, created, updated);
    }
}

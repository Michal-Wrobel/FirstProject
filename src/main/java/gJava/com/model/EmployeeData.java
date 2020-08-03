package gJava.com.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class EmployeeData extends Employee {
    private UUID id;
    private UUID employeeID;
    private BigDecimal monthSalary;
   // private LocalDate created;
  //  private LocalDate updated;

    public EmployeeData() {

    }

    public EmployeeData(UUID id, String firstName, String lastName, LocalDate created, LocalDate updated
            , BigDecimal monthSalary) {
        super(id, firstName, lastName, created, updated);
        this.employeeID = id;
        this.id = UUID.randomUUID();
    //    this.created = LocalDate.now();
    //    this.updated = LocalDate.now();
        this.monthSalary = monthSalary;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public UUID getEmployeeID() {
        return employeeID;
    }

    public BigDecimal getMonthSalary() {
        return monthSalary;
    }

//    @Override
//    public LocalDate getCreated() {
//        return created;
//    }
//
//    @Override
//    public LocalDate getUpdated() {
//        return updated;
//    }



}

package employee.management.model;

import jakarta.persistence.*;
import lombok.*;
@AllArgsConstructor

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="employee_Data")
public class EmployeeData{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   employeeId;
    private String employeeName;
    private String employeeEmail;
    private double employeeSalary;
    private String employeeRole;
}

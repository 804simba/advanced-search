package com.simba.advanced.search.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    private Long employeeId;

    private String firstName;

    private String lastName;

    private String jobTitle;

    private Date hireDate;

    private Long managerId;

    private Double salary;

    private Double commission;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;
}

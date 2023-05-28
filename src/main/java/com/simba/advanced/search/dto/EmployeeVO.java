package com.simba.advanced.search.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeVO {
    private Long employeeId;

    private String firstName;

    private String lastName;

    private String jobTitle;

    private Long managerId;

    private Date hireDate;

    private double salary;

    private double commission;

    private DepartmentVO department;
}

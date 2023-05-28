package com.simba.advanced.search.dto;

import lombok.Data;

@Data
public class SalaryGradeVO {
    private Long grade;

    private double minSalary;

    private double maxSalary;
}

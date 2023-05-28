package com.simba.advanced.search.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "salary_grades")
public class SalaryGrade {
    @Id
    private Long grade;

    private Double minSalary;

    private Double maxSalary;
}

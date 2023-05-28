package com.simba.advanced.search.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="departments")
public class Department {
    @Id
    private Long departmentId;

    private String departmentName;

    @OneToMany(
            mappedBy = "department"
    )
    @JsonIgnore
    private List<Employee> employees;
}

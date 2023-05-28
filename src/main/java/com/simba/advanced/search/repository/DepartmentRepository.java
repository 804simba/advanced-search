package com.simba.advanced.search.repository;

import com.simba.advanced.search.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

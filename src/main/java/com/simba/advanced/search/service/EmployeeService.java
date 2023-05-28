package com.simba.advanced.search.service;

import com.simba.advanced.search.domain.Employee;
import com.simba.advanced.search.dto.EmployeeSearchVO;
import com.simba.advanced.search.dto.EmployeeVO;
import org.springframework.data.domain.Page;

public interface EmployeeService {
    EmployeeVO saveEmployee(EmployeeVO employeeVO);
    Page<Employee> findBySearchCriteria(int pageNumber, int pageSize, EmployeeSearchVO searchDTO);
}

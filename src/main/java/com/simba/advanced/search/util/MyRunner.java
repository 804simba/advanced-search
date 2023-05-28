package com.simba.advanced.search.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simba.advanced.search.dto.DepartmentVO;
import com.simba.advanced.search.dto.EmployeeVO;
import com.simba.advanced.search.dto.SalaryGradeVO;
import com.simba.advanced.search.service.DepartmentService;
import com.simba.advanced.search.service.EmployeeService;
import com.simba.advanced.search.service.SalaryGradeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class MyRunner implements CommandLineRunner {
    private final EmployeeService employeeService;

    private final SalaryGradeService salaryGradeService;

    private final DepartmentService departmentService;

    @Override
    public void run(String... args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/department.json");
            log.info("Saving department data");
            List<DepartmentVO> departmentVOS = objectMapper.readValue(inputStream, new TypeReference<>() {
            });
            departmentVOS.forEach(departmentService::saveDepartment);
            log.info("Successfully saved department");

            inputStream = TypeReference.class.getResourceAsStream("/json/employee.json");
            log.info("Saving employee data");
            List<EmployeeVO> employeeVOS = objectMapper.readValue(inputStream, new TypeReference<>() {
            });
            employeeVOS.forEach(employeeService::saveEmployee);
            log.info("Successfully saved employee");

            inputStream = TypeReference.class.getResourceAsStream("/json/salaryGrade.json");
            log.info("Saving salary grade data");
            List<SalaryGradeVO> salaryGradeVOS = objectMapper.readValue(inputStream, new TypeReference<>() {
            });
            salaryGradeVOS.forEach(salaryGradeService::saveSalaryGrade);
            log.info("Successfully saved salary grade");
        } catch (IOException e) {
            log.error("Error saving {}", e.getMessage());
        }
    }
}

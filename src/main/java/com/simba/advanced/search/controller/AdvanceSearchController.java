package com.simba.advanced.search.controller;

import com.simba.advanced.search.domain.Employee;
import com.simba.advanced.search.dto.ApiResponseVO;
import com.simba.advanced.search.dto.EmployeeSearchVO;
import com.simba.advanced.search.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class AdvanceSearchController {

    private final EmployeeService employeeService;

    @PostMapping("/search")
    public ResponseEntity<ApiResponseVO> searchEmployees(
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
            @RequestBody EmployeeSearchVO searchDTO) {

        Page<Employee> employees = employeeService.findBySearchCriteria(pageNumber, pageSize, searchDTO);

        ApiResponseVO apiResponseVO = ApiResponseVO.builder()
                .data(employees.toList())
                .responseCode(HttpStatus.OK)
                .message("Successfully retrieved employee information")
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(apiResponseVO);
    }
}

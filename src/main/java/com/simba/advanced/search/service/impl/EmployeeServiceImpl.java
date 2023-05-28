package com.simba.advanced.search.service.impl;

import com.simba.advanced.search.domain.Employee;
import com.simba.advanced.search.dto.EmployeeSearchVO;
import com.simba.advanced.search.dto.EmployeeVO;
import com.simba.advanced.search.mapper.DomainDTOMapper;
import com.simba.advanced.search.repository.EmployeeRepository;
import com.simba.advanced.search.service.EmployeeService;
import com.simba.advanced.search.util.EmployeeSpecificationBuilder;
import com.simba.advanced.search.util.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeVO saveEmployee(EmployeeVO employeeVO) {
        Employee employee = DomainDTOMapper.getEmployee(employeeVO);
        return DomainDTOMapper.getEmployeeVO(employeeRepository.saveAndFlush(employee));
    }
    @Override
    public Page<Employee> findBySearchCriteria(int pageNumber, int pageSize, EmployeeSearchVO searchVO) {

        EmployeeSpecificationBuilder builder = new EmployeeSpecificationBuilder();

        List<SearchCriteria> criteriaList = searchVO.getSearchCriterias();

        if (criteriaList != null) {
            criteriaList.forEach(criteria -> {
                criteria.setDataOption(searchVO.getDataOption());
                builder.with(criteria);
            });
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize,
                Sort.by("firstName").ascending()
                        .and(Sort.by("lastName")).ascending()
                        .and(Sort.by("department")).ascending());


        return employeeRepository.findAll(builder.build(), pageable);
    }
}

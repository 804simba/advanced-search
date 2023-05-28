package com.simba.advanced.search.service.impl;

import com.simba.advanced.search.domain.Department;
import com.simba.advanced.search.dto.DepartmentVO;
import com.simba.advanced.search.mapper.DomainDTOMapper;
import com.simba.advanced.search.repository.DepartmentRepository;
import com.simba.advanced.search.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentVO saveDepartment(final DepartmentVO departmentVO) {
        Department department = DomainDTOMapper.getDepartment(departmentVO);
        return DomainDTOMapper.getDepartmentVO(departmentRepository.saveAndFlush(department));
    }
}

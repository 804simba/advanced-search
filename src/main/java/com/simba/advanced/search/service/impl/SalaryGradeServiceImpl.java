package com.simba.advanced.search.service.impl;

import com.simba.advanced.search.domain.SalaryGrade;
import com.simba.advanced.search.dto.SalaryGradeVO;
import com.simba.advanced.search.mapper.DomainDTOMapper;
import com.simba.advanced.search.repository.SalaryGradeRepository;
import com.simba.advanced.search.service.SalaryGradeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SalaryGradeServiceImpl implements SalaryGradeService {
    private final SalaryGradeRepository salaryGradeRepository;

    @Override
    public SalaryGradeVO saveSalaryGrade(SalaryGradeVO salaryGradeVO) {
        SalaryGrade salaryGrade = DomainDTOMapper.getSalaryGrade(salaryGradeVO);
        return DomainDTOMapper.getSalaryGradeVO(salaryGradeRepository.saveAndFlush(salaryGrade));
    }
}

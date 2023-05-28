package com.simba.advanced.search.dto;

import com.simba.advanced.search.util.SearchCriteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSearchVO {
    private List<SearchCriteria> searchCriterias;

    private String dataOption;
}

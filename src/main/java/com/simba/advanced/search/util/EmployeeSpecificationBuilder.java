package com.simba.advanced.search.util;

import com.simba.advanced.search.domain.Employee;
import com.simba.advanced.search.enums.SearchOperation;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSpecificationBuilder {
    private final List<SearchCriteria> params;

    public EmployeeSpecificationBuilder() {
        this.params = new ArrayList<>();
    }

    public final EmployeeSpecificationBuilder with(String key, Object value, String operation) {
        params.add(new SearchCriteria(key, value, operation));
        return this;
    }

    public final EmployeeSpecificationBuilder with(SearchCriteria searchCriteria) {
        params.add(searchCriteria);
        return this;
    }

    public Specification<Employee> build() {
        if (params.size() == 0) {
            return null;
        }

        Specification<Employee> result = new EmployeeSpecification(params.get(0));

        for (int index = 1; index < params.size(); index++) {
            SearchCriteria searchCriteria = params.get(index);
            result = SearchOperation.getDataOption(searchCriteria.getDataOption()) == SearchOperation.ALL ? Specification.where(result)
                    .and(new EmployeeSpecification(searchCriteria)) : Specification.where(result)
                    .or(new EmployeeSpecification(searchCriteria));
        }
        return result;
    }
}

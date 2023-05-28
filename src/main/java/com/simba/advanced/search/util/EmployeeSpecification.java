package com.simba.advanced.search.util;

import com.simba.advanced.search.domain.Department;
import com.simba.advanced.search.domain.Employee;
import com.simba.advanced.search.enums.SearchOperation;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

import java.util.Objects;

public class EmployeeSpecification implements Specification<Employee> {

    private final SearchCriteria searchCriteria;

    public EmployeeSpecification(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(@NonNull Root<Employee> root,
                                 @NonNull CriteriaQuery<?> query,
                                 @NonNull CriteriaBuilder cb) {
        String stringToSearch =
                searchCriteria.getValue().toString().toLowerCase();

        switch (Objects.requireNonNull(
                SearchOperation.getSimpleOperation(searchCriteria.getOperation())
        )) {
            case CONTAINS -> {
                if (searchCriteria.getFilterKey().equals("departmentName")) {
                    return cb.like(cb.lower(departmentJoin(root).get(searchCriteria.getFilterKey())), "%" + stringToSearch + "%");
                }
                return cb.like(cb.lower(root.get(searchCriteria.getFilterKey())), "%" + stringToSearch + "%");
            }
            case DOES_NOT_CONTAIN -> {
                if (searchCriteria.getFilterKey().equals("departmentName")) {
                    return cb.notLike(cb.lower(departmentJoin(root).get(searchCriteria.getFilterKey())), "%" + stringToSearch + "%");
                }
                return cb.notLike(cb.lower(root.get(searchCriteria.getFilterKey())), "%" + stringToSearch + "%");
            }
            case BEGINS_WITH -> {
                if (searchCriteria.getFilterKey().equals("departmentName")) {
                    return cb.like(cb.lower(departmentJoin(root).get(searchCriteria.getFilterKey())), stringToSearch + "%");
                }
                return cb.like(cb.lower(root.get(searchCriteria.getFilterKey())), stringToSearch + "%");
            }
            case DOES_NOT_BEGIN_WITH -> {
                if (searchCriteria.getFilterKey().equals("departmentName")) {
                    return cb.notLike(cb.lower(departmentJoin(root).get(searchCriteria.getFilterKey())), stringToSearch + "%");
                }
                return cb.notLike(cb.lower(root.get(searchCriteria.getFilterKey())), stringToSearch + "%");
            }
            case ENDS_WITH -> {
                if (searchCriteria.getFilterKey().equals("departmentName")) {
                    return cb.like(cb.lower(departmentJoin(root).get(searchCriteria.getFilterKey())), "%" + stringToSearch);
                }
                return cb.like(cb.lower(root.get(searchCriteria.getFilterKey())), "%" + stringToSearch);
            }
            case DOES_NOT_END_WITH -> {
                if (searchCriteria.getFilterKey().equals("departmentName")) {
                    return cb.notLike(cb.lower(departmentJoin(root).get(searchCriteria.getFilterKey())), "%" + stringToSearch);
                }
                return cb.notLike(cb.lower(root.get(searchCriteria.getFilterKey())), "%" + stringToSearch);
            }
            case EQUAL -> {
                if (searchCriteria.getFilterKey().equals("departmentName")) {
                    return cb.equal(cb.lower(departmentJoin(root).get(searchCriteria.getFilterKey())), searchCriteria.getValue());
                }
                return cb.notEqual(cb.lower(root.get(searchCriteria.getFilterKey())), stringToSearch);
            }
            case NULL -> {
                return cb.isNull(root.get(searchCriteria.getFilterKey()));
            }
            case NOT_NULL -> {
                return cb.isNotNull(root.get(searchCriteria.getFilterKey()));
            }
            case GREATER_THAN -> {
                return cb.greaterThan(root.get(searchCriteria.getFilterKey()), searchCriteria.getValue().toString());
            }
            case LESS_THAN -> {
                return cb.lessThan(root.get(searchCriteria.getFilterKey()), searchCriteria.getValue().toString());
            }
            case GREATER_THAN_EQUAL -> {
                return cb.greaterThanOrEqualTo(root.get(searchCriteria.getFilterKey()), searchCriteria.getValue().toString());
            }
            case LESS_THAN_EQUAL -> {
                return cb.lessThanOrEqualTo(root.get(searchCriteria.getFilterKey()), searchCriteria.getValue().toString());
            }
        }
        return null;
    }

    private Join<Employee, Department> departmentJoin(Root<Employee> root) {
        return root.join("department");
    }
}

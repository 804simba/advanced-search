package com.simba.advanced.search.mapper;

import com.simba.advanced.search.domain.Department;
import com.simba.advanced.search.domain.Employee;
import com.simba.advanced.search.domain.SalaryGrade;
import com.simba.advanced.search.dto.DepartmentVO;
import com.simba.advanced.search.dto.EmployeeVO;
import com.simba.advanced.search.dto.SalaryGradeVO;
import org.modelmapper.ModelMapper;


public class DomainDTOMapper {

    public static Employee getEmployee(EmployeeVO employeeVO) {
        if (employeeVO == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(employeeVO, Employee.class);
    }

    public static EmployeeVO getEmployeeVO(Employee employee) {
        if (employee == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(employee, EmployeeVO.class);
    }

    public static Department getDepartment(DepartmentVO departmentVO) {
        if (departmentVO == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(departmentVO, Department.class);
    }

    public static DepartmentVO getDepartmentVO(Department department) {
        if (department == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(department, DepartmentVO.class);
    }

    public static SalaryGrade getSalaryGrade(SalaryGradeVO salGradeDto){
        if(salGradeDto == null){
            return null;
        }

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(salGradeDto, SalaryGrade.class);
    }

    public static SalaryGradeVO getSalaryGradeVO(SalaryGrade salGrade){
        if(salGrade == null){
            return null;
        }

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(salGrade, SalaryGradeVO.class);
    }
}

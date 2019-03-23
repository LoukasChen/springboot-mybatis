package com.csp.service;

import com.csp.entity.EmpDept;
import com.csp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee selectEmpById(Integer id);

    List<Employee> selectEmpList(int pageNum,int PageSize);

    List<EmpDept> selectEmpDeptList();

    int addEmp(Employee employee);

    int updateEmpById(Employee employee);

    int deleteEmpById(Integer id);
}

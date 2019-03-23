package com.csp.dao.oracle;

import com.csp.entity.EmpDept;
import com.csp.entity.Employee;

import java.util.List;

public interface EmployeeMapper {

     Employee selectEmpById(Integer id);

     List<Employee> selectEmpList();

     List<EmpDept> selectEmpDeptList();

     int addEmp(Employee employee);

     int updateEmpById(Employee employee);

     int deleteEmpById(Integer id);
}

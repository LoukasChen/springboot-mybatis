package com.csp.service;

import com.csp.dao.oracle.EmployeeMapper;
import com.csp.entity.EmpDept;
import com.csp.entity.Employee;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee selectEmpById(Integer id) {
        return employeeMapper.selectEmpById(id);
    }

    @Override
    public List<Employee> selectEmpList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return employeeMapper.selectEmpList();
    }

    @Override
    public List<EmpDept> selectEmpDeptList() {
        return employeeMapper.selectEmpDeptList();
    }

    @Override
    public int addEmp(Employee employee) {
       return employeeMapper.addEmp(employee);
    }

    @Override
    public int updateEmpById( Employee employee) {
        return employeeMapper.updateEmpById(employee);
    }

    @Override
    public int deleteEmpById(Integer id) {
      return employeeMapper.deleteEmpById(id);
    }
}

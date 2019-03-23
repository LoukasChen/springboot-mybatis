package com.csp.dao.oracle;

import com.csp.entity.Dept;

import java.util.List;

public interface DeptMapper {

     Dept selectDeptById(Integer id);

     List<Dept> selectDeptList();


     void addDept();

     void updateDeptById(Integer id);

     void deleteDeptById(Integer id);

}

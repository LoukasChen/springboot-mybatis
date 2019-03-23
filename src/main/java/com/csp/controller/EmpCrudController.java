package com.csp.controller;

import com.csp.entity.EmpDept;
import com.csp.entity.Employee;
import com.csp.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping("/emp")
public class EmpCrudController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    @ResponseBody
    public Employee select(@PathVariable("id") Integer id){
        return employeeService.selectEmpById(id);
    }

    @GetMapping("/page")
    @ResponseBody
    public List<Employee> page(@RequestBody Employee employee, @PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize){
        List<Employee> employeeList = employeeService.selectEmpList(pageNum, pageSize);
        Logger logger = LoggerFactory.getLogger(EmpCrudController.class);
        logger.info("分页查询成功!"+employeeList);
        return employeeList;
    }


     //关联查询信息
    @GetMapping("/list")
    @ResponseBody
    public List<EmpDept> list(){
        return employeeService.selectEmpDeptList();
    }

    @PostMapping("/add")
    public String add(Employee employee){
        int addEmp = employeeService.addEmp(employee);
        if (addEmp != 0){
            return "新增员工信息成功！";
        }else {
            return "新增员工信息失败！";
        }
    }

    @PutMapping("/update")
    public String update(Employee employee){
        int updateInfo = employeeService.updateEmpById(employee);
        if (updateInfo != 0){
            return "修改员工信息成功！";
        }else {
            return "修改员工信息失败！";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        int res = employeeService.deleteEmpById(id);
        if (res != 0){
            return "删除"+id+"号员工成功！";
        }else {
            return "您删除的员工不存在或错误！";
        }
    }

    @RequestMapping("/test")

    public String test(){

        return "redirect:/emp/"+7369;
    }



}

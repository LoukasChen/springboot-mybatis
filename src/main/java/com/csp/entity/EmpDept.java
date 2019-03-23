package com.csp.entity;

import lombok.Data;

@Data
public class EmpDept {
    private Integer empId;
    private String eName;
    private Integer sal;
    private Dept dept;

}

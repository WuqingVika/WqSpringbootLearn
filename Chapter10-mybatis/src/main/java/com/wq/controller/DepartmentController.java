package com.wq.controller;

import com.wq.bean.Department;
import com.wq.mapper.DepartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuqingvika on 2018/3/31.
 */
@RestController
public class DepartmentController {
    @Autowired
    DepartMapper departMapper;

    @GetMapping("/getdept/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){
        return departMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
         departMapper.insertDept(department);
        return department;
    }
}

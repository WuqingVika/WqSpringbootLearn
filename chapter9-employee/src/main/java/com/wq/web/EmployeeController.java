package com.wq.web;

import com.wq.dao.EmployeeDao;
import com.wq.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * Created by wuqingvika on 2018/3/21.
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @GetMapping("/emps")
    public  String list(Model model){
        Collection<Employee> employees=employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }
}

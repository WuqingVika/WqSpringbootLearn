package com.wq.web;

import com.wq.dao.DepartmentDao;
import com.wq.dao.EmployeeDao;
import com.wq.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by wuqingvika on 2018/3/21.
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;//员工
    @Autowired
    DepartmentDao departmentDao;//部门
    @GetMapping("/emps")
    public  String list(Model model){
        Collection<Employee> employees=employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //跳转到添加页面
    @GetMapping (value = "/emp")
    public String toAdd(ModelMap modelMap){
        //查出添加页面下拉框要绑定的所有部门 在页面显示。
        modelMap.put("depts",departmentDao.getDepartments());
        return "emp/add";
    }

    //添加员工信息
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("添加的员工信息["+employee+"]");
        //保存员工信息
        employeeDao.save(employee);
        //添加完一条数据重定向到列表页面 /代表根目录的意思
        return "redirect:/emps";
    }
    //跳转到编辑页面
    @GetMapping (value = "/emp/{id}")
    public String toEdit(@PathVariable("id") Integer id, ModelMap modelMap){
        //跳转到编辑页面 回显数据
        modelMap.put("emp",employeeDao.get(id));
        System.out.println("要修改的员工信息["+employeeDao.get(id)+"]");
        modelMap.put("depts",departmentDao.getDepartments());
        //由于添加、修改页面二合一，所以跳转请求还是去修改页面。
        return "emp/add";
    }

    //员工修改
    @PutMapping(value = "/emp")
    public String editEmployee( Employee employee){
        System.out.println("修改的员工信息["+employee+"]");
        employeeDao.save(employee);//修改和添加二合一
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}

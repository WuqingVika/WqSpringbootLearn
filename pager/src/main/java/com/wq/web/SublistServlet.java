package com.wq.web;

import com.wq.Constant;
import com.wq.entity.Pager;
import com.wq.entity.Student;
import com.wq.service.StudentService;
import com.wq.service.impl.SublistStudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wuqingvika on 2018/4/10.
 */
public class SublistServlet extends HttpServlet {
    private StudentService studentService=new SublistStudentServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收request参数
        String stuName=req.getParameter("stuName");
        String genderStr=req.getParameter("gender");
        Integer gender=genderStr==null? Constant.DEFAULT_GENDER:Integer.parseInt(genderStr);

        String pageNumStr=req.getParameter("pageNum");
        Integer pageNum=pageNumStr==null? Constant.DEFAULT_PAGE_NUM:Integer.parseInt(pageNumStr);

        String pageSizeStr=req.getParameter("pageSize");
        Integer pageSize=pageSizeStr==null? Constant.DEFAULT_PAGE_SIZE:Integer.parseInt(pageSizeStr);

        //2.组装查询条件
        Student searchModel=new Student();
        searchModel.setGender(gender);
        searchModel.setName(stuName);
        //3.调用service返回查询结果
        Pager<Student> pager = studentService.getStudent(searchModel, pageNum, pageSize);
        //4.返回结果到前端页面
        req.setAttribute("stuName", stuName);
        req.setAttribute("gender", gender);
        req.setAttribute("result",pager);
        req.getRequestDispatcher("../sublistStudent.jsp").forward(req,resp);
    }
}

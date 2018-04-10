package com.wq.service.impl;

import com.wq.dao.StudentDao;
import com.wq.dao.impl.SublistStudentDaoImpl;
import com.wq.entity.Pager;
import com.wq.entity.Student;
import com.wq.service.StudentService;

/**
 * Created by wuqingvika on 2018/4/10.
 */
public class SublistStudentServiceImpl implements StudentService{
    private StudentDao studentDao;

    public SublistStudentServiceImpl() {
        this.studentDao=new SublistStudentDaoImpl();
    }

    @Override
    public Pager<Student> getStudent(Student searchModel, Integer pageNum, Integer pageSize) {
        return studentDao.getStudent(searchModel,pageNum,pageSize);
    }
}

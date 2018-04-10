package com.wq.dao;

import com.wq.entity.Pager;
import com.wq.entity.Student;

/**
 * Created by wuqingvika on 2018/4/10.
 */
public interface StudentDao {
    /**
     * 根据查询条件查询学生分页信息
     * @param searchModel 封装的查询条件
     * @param pageNum 查询第几页数据
     * @param pageSize 每页显示 多少条记录
     * @return
     */
   public Pager<Student> getStudent(Student searchModel, Integer pageNum, Integer pageSize);
}

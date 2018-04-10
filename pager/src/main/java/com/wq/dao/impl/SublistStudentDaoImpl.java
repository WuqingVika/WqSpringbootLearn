package com.wq.dao.impl;

import com.wq.Constant;
import com.wq.dao.StudentDao;
import com.wq.entity.Pager;
import com.wq.entity.Student;
import com.wq.util.JdbcUtil;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.util.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wuqingvika on 2018/4/10.
 */
public class SublistStudentDaoImpl implements StudentDao {
    @Override
    public Pager<Student> getStudent(Student searchModel, Integer pageNum, Integer pageSize) {
        List<Student> allStudent = getAllStudent(searchModel);
        Pager<Student> studentPager=new Pager<Student>(allStudent,pageNum,pageSize);
        return studentPager;
    }

    public List<Student> getAllStudent(Student searchModel){
        List<Student> result=new ArrayList<Student>();
        List<Object> paramList=new ArrayList<Object>();//定义参数列表
        String stuName=searchModel.getName();
        Integer gender=searchModel.getGender();
        StringBuilder sql=new StringBuilder("select * from student where 1=1");
        if(!StringUtils.isEmpty(stuName)){
            sql.append(" and name like ?");
            paramList.add("%"+stuName+"%");
        }
        if(gender== Constant.GENDER_FEMALE||gender==Constant.GENDER_MALE){
            sql.append(" and gender = ?");
            paramList.add(gender);
        }
        JdbcUtil jdbcUtil=null;
        try {
            jdbcUtil=new JdbcUtil();
            jdbcUtil.getConnection();
            List<Map<String, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
            if(mapList!=null&&!mapList.isEmpty()){
                for(Map<String, Object> map:mapList ) {
                    Student student=new Student(map);
                    result.add(student);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("查询所有数据异常!",e);
        }finally {
            if(jdbcUtil!=null){
                jdbcUtil.releaseConn();//释放资源
            }
        }
        return  result;
    }
}

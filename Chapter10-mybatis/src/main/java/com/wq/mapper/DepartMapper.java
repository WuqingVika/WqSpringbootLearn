package com.wq.mapper;

import com.wq.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * Created by wuqingvika on 2018/3/31.
 */
@Mapper
public interface DepartMapper {
    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);//开启驼峰式命名数据库字段命名：department_name

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}

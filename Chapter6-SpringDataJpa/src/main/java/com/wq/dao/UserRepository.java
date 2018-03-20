package com.wq.dao;

import com.wq.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by qwu on 2018/3/15.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    //Spring-data-jpa的一大特性：通过解析方法名创建查询。
    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);

}

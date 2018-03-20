package com.wq.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by qwu on 2018/3/19.
 */
@Component
@ConfigurationProperties(prefix = "person")
public class Wuqingvika {
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Wuqingvika{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

package com.wq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.wq.mapper")//扫描我们的映射文件 这样就不需要在每个映射文件上面都写@Mapper注解了
@SpringBootApplication
public class Chapter10MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter10MybatisApplication.class, args);
	}
}

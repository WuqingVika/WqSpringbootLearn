# 跟小吴庆一起实战SpringBoot
## 本文仅是我在学习SpringBoot实战中遇到的一些问题及主要知识点的总结。如有不足之处，欢迎指正！
### 一、我的第一个SpringBoot应用
- 1.1 说明
  - 简单创建一个Springboot入门应用。
- 1.2 代码
  - [Chapter1](https://github.com/WuqingVika/WqSpringbootLearn/tree/master/Chapter1)
- 1.3 笔记
  - 关于@RestController
     - @RestController=@Controller+@ResponseBody()&rarr;返回json格式。
- 1.4 踩坑
  -  测试的时候这个注释@SpringApplicationConfiguration(classes = MockServletContext.class)较新版取消了此注解，改成@SpringBootTest即可。
  
### 二、thymeleaf模板使用
- 2.1 说明
  - 如何使用模板将我们属性值显示到页面中。
- 2.2 代码
  - [Chapter2](https://github.com/WuqingVika/WqSpringbootLearn/tree/master/Chapter2)
- 2.3 笔记
   - 无
- 2.4 踩坑
  - 属性配置文件中空格问题需要注意，不要将多个属性配置在同一行。  

### 三、Spring Boot构建RESTful API与单元测试
- 3.1 说明
  - 完整的增删改用户案例。
- 3.2 代码
  - [Chapter3](https://github.com/WuqingVika/WqSpringbootLearn/tree/master/Chapter3)
- 3.3 笔记
   - 无
- 3.4 踩坑
  - 因为Module是拷贝的导致输出的class文件存储上个module编译的class文件，导致测试时报错出现重复启动类信息，将其他Module中编译文件删除即可。  

### 四、Spring Boot中使用Swagger2构建强大的RESTful API文档
- 4.1 说明
  - 在上个应用的基础上，编写了使用Swagger2构建强大的RESTful API文档。
- 4.2 代码
  - [Chapter4Swagger2](https://github.com/WuqingVika/WqSpringbootLearn/tree/master/Chapter4Swagger2)
- 4.3 笔记
   - 无
- 4.4 踩坑
  - 像删除、更新、根据ID获取用户信息需要传入ID的时候，注解需要加上paramType="path";
     - "@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType="path")。  
 
### 五、使用JdbcTemplate访问数据库
- 5.1 说明
  - 如标题。
- 5.2 代码
  - [Chapter5-JdbcTemplate](https://github.com/WuqingVika/WqSpringbootLearn/tree/master/Chapter5-JdbcTemplate)
- 5.3 笔记
   - 无
- 5.4 踩坑
  - 配置文件中去掉引入JNDI数据源的配置信息
  
### 六、使用Spring-data-jpa让数据访问更简单、更优雅
- 6.1 说明
  - 如标题。
- 6.2 代码
  - [Chapter6-SpringDataJpa](https://github.com/WuqingVika/WqSpringbootLearn/tree/master/Chapter5-SpringDataJpa)
- 6.3 笔记
   - 配置文件
     - create：每次加载hibernate时都会删除上一次的生成的表，然后根据你的model类再重新来生成新表，哪怕两次没有任何改变也要这样执行，这就是导致数据库表数据丢失的一个重要原因。
     - create-drop：每次加载hibernate时根据model类生成表，但是sessionFactory一关闭,表就自动删除。
     - update：最常用的属性，第一次加载hibernate时根据model类会自动建立起表的结构（前提是先建立好数据库），以后加载hibernate时根据model类自动更新表结构，即使表结构改变了但表中的行仍然存在不会删除以前的行。要注意的是当部署到服务器后，表结构是不会被马上建立起来的，是要等应用第一次运行起来后才会。
     - validate：每次加载hibernate时，验证创建数据库表结构，只会和数据库中的表进行比较，不会创建新表，但是会插入新值。
- 6.4 踩坑
  - User实体类需要无参、带参构造方法
  


### 七、配置文件
- 笔记详见springboot.md文件
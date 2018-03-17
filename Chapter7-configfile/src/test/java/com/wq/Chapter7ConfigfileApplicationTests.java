package com.wq;

import com.wq.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter7ConfigfileApplicationTests {

	@Autowired
	private Person person;
	@Test
	public void contextLoads() {
		System.out.println(person.toString());//我这里用Properties就是出现乱码 醉也。
		//输出结果：
		//Person{name='吴庆', age=22,
		// birthDay=Tue Jul 18 00:00:00 CST 1995,
		// boss=false, maps={k1=wq, k2=22},
		// lists=[wu, qing], dog=Dog{name='来福', age=11}}
	}

}

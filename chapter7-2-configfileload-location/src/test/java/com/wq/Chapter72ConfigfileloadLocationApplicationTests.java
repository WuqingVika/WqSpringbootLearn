package com.wq;

import com.wq.domain.Wuqingvika;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter72ConfigfileloadLocationApplicationTests {

	@Autowired
	private Wuqingvika wuqingvika;
	@Test
	public void contextLoads() {
		System.out.println(wuqingvika.toString());
	}

}

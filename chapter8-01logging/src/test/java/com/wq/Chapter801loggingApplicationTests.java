package com.wq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter801loggingApplicationTests {

	@Test
	public void contextLoads() {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		//日志级别 由低到高; 可以调整日志的级别
		logger.trace("trace日志---");
		logger.debug("debug日志。。。");
		logger.info("info日志..");
		logger.warn("warn日志..");
		logger.error("error日志...");
		//会发现只输出了info\warn\error日志，这是因为SpringBoot默认给我们使用的是info级别的。
		//所以只会输出Info级别以上的日志。
		//但如果我们在配置文件application.properties配置级别就会使用我们配置的级别，否则就会使用默认的springboot配置的日志级别。
	}

}

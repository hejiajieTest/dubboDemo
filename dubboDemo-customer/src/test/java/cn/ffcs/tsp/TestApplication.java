package cn.ffcs.tsp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ffcs.tsp.api.DemoService;

public class TestApplication {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context 
		= new ClassPathXmlApplicationContext("classpath:dubbo-consumer.xml");
		DemoService demoService = (DemoService) context.getBean("demoService");
		demoService.test();
	}
}

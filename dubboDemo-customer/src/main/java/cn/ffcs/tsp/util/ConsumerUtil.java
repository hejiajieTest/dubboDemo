package cn.ffcs.tsp.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ffcs.tsp.api.DemoService;

public class ConsumerUtil {

	public static ConsumerUtil cu = new ConsumerUtil() ;
	private static ApplicationContext cx = null ;
	private ConsumerUtil(){
		
	}
	static{
		ConsumerUtil.getInstance().loadPath();
	}
	
	
	public static DemoService getDemoService(){
		
		DemoService demoService = (DemoService) cx.getBean("demoService");
		return demoService;
	}
	
	public void loadPath(){
		cx= new ClassPathXmlApplicationContext("classpath:dubbo-consumer.xml");
	}
	public static ConsumerUtil getInstance(){
		return cu;
	}
	public Object getBean(String bean){
		return cx.getBean(bean);
	}
	
}

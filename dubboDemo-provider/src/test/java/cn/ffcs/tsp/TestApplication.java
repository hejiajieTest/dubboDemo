package cn.ffcs.tsp;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApplication {
	//服务端用测试类启动，客户端用tomcat启动，可以访问
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context 
	        = new ClassPathXmlApplicationContext("classpath:dubbo-provider.xml");
	    //context.start();
	    // 阻塞当前进程，否则程序会直接停止
	    System.in.read();
	}
}

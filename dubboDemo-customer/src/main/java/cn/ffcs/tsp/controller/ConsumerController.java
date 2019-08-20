package cn.ffcs.tsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ffcs.tsp.util.ConsumerUtil;

@Controller
@RequestMapping("/test")
public class ConsumerController {

	@RequestMapping("/test.do")
	public void test(){
		//DemoService：ConsumerUtil.getDemoService()
		System.out.println("start consumer!!!!");
		ConsumerUtil.getDemoService().test();
	}
}

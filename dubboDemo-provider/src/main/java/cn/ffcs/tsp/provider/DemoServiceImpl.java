package cn.ffcs.tsp.provider;

import cn.ffcs.tsp.api.DemoService;

public class DemoServiceImpl implements DemoService{

	@Override
	public void test() {
		System.out.println("nihao,dubbo");
	}

}

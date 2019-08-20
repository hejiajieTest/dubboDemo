简单的dubbo项目，此项目是因为之前搭建的dubbo-mybatis项目中出现consumer调用不到provider而单独创建的一个简单的小demo
引入dubbo的jar包的时候，需要将spring包移除，不然会冲突，
会报需要1.5或者以上jre运行环境， 但是此时jre配置的是1.8了。
spring注解扫描没法识别@Reference注解，dubbo注解没法扫描@Controller，
应该先spring注解扫好了之后，在去加载reference注解
对于此问题，解决办法，网上给的结论是spring和dubbo扫描顺序问题，修改顺序之后，仍会报空指针，
后面再无意中发现是项目中dubbo-provider.xml中<dubbo:annotation package="cn.ffcs.tsp.dubboService.impl" />
package中dubboService写成了dubboservice导致扫描不到，从而一直为空。
4、采用main方式测试调用
5、采用tomcat方式部署
使用jetty启动，报错 javax.servlet.http.HttpSessionIdListener
原因需要删除javax-servlet-api jar包
有个大坑：provider无法注册，报的错误有两种No provider available for the service，这种很明显的错误
第二种：javax.servlet.http.HttpServletResponse.getStatus()I
第二种说是spring4.1与servlet.api版本冲突，
这两种情况根本原因还是因为provider没有注册成功，但是直接访问index.jsp是可以访问的，具体原因不清除，
调试过程中，总感觉provider中的信息未执行，于是我修改启动方式，web.xml中直接指向applicationContext.xml,
而不通过WEB-InFo底下的springmvc-servlet.xml中import文件applicationContext,再次运行tomcat或者jetty时，都可以成功。
tomcat测试地址：http://localhost:8080/dubbo-customer/manualInfo/findAll.do
jetty测试地址：http://localhost:1800/consumer/manualInfo/findAll.do
补充一点：当我在<dubbo-service 加入version=“1.0”的时候，是没法找到provider服务端的，
重要的事情说三遍，provider不能通过直接引用spring配置的启动类，一定要用
<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classpath:dubbo-provider.xml</param-value>
</init-param>
,这个问题花了很长时间。
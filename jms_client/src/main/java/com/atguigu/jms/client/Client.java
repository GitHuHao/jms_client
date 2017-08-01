package com.atguigu.jms.client;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.atguigu.jms.service.HelloService;

public class Client {
	
	private static final Logger LOG = Logger.getLogger(Client.class);
	private static int index = 0;
	
	private static void invoke(HelloService service) {
		String name = "1380013800" + (String.valueOf(index++));
		String result = service.sayHello(name);
		LOG.info("Client gets result: " + result);
	}
	
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "client.xml" });
		HelloService service = (HelloService) ctx.getBean("helloService");
		for(int i=0; i<100; i++) {
			invoke(service);
		}
	}
}
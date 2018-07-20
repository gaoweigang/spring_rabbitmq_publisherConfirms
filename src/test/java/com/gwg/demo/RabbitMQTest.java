package com.gwg.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gwg.demo.sender.HelloSender;

/**
 * debug mapper
 * 
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-rabbitmq.xml") 
public class RabbitMQTest {

	@Autowired
	private HelloSender helloSender;
	

	@Test
	public void hello() throws Exception {
		helloSender.send();
	}

}

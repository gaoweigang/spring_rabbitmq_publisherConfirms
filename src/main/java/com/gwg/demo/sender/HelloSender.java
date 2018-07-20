package com.gwg.demo.sender;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloSender.class);
	
	//使用Autowired注解 免去setter方法注入，如果使用setter,还需要在spring配置文件中配置注入对象
	@Autowired
    private AmqpTemplate rabbitTemplate;
	
	@Value("${rabbitmq.direct.exchange}")
	private String exchange;
	
	@Value("${rabbitmq.queue}")
	private String queue;
 
    public void send() {
    	logger.info("rabbitTemplate:{}, exhange:{}, queue:{}" , rabbitTemplate, exchange, queue);
        String context = "hello gwg " + new Date();
        logger.info("Sender : " + context);
        this.rabbitTemplate.convertAndSend(exchange, queue, context);
    }

/*	public AmqpTemplate getRabbitTemplate() {
		return rabbitTemplate;
	}

	public void setRabbitTemplate(AmqpTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
    */
 
}

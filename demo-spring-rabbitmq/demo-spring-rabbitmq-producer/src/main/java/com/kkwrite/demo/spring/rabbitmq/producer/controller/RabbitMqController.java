package com.kkwrite.demo.spring.rabbitmq.producer.controller;

import javax.annotation.Resource;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
 * 类说明 
 *
 * @author Soosky Wang
 * @date 2018年10月11日 下午4:59:08 
 * @version 1.0.0
 */
@Controller
@RequestMapping("/rabbitmq")
public class RabbitMqController {
	
	@Resource(name = "rabbitTemplate")
	private RabbitTemplate rabbitTemplate;

	@RequestMapping("/fanoutSender")
	public @ResponseBody String fanoutSender(@RequestParam("message") String message) {
		String opt = "";
		try {
			for (int i = 0; i < 3; i++) {
				String str = "Fanout, the message_" + i + " is: " + message;
				rabbitTemplate.send("fanout-exchange", "", new Message(str.getBytes(), new MessageProperties()));
				System.out.println("Send message: " + str);
			}
			opt = "suc";
		} catch (Exception e) {
			e.printStackTrace();
			opt = e.getCause().toString();
		}
		return opt;
	}
	
	@RequestMapping("/topicSender")
	public @ResponseBody String topicSender(@RequestParam("message") String message) {
		String opt = "";
		try {
			String[] severities = { "error", "info", "warning" };
			String[] modules = { "email", "order", "user" };
			for (int i = 0; i < severities.length; i++) {
				for (int j = 0; j < modules.length; j++) {
					String routeKey = severities[i] + "." + modules[j];
					String str = "the message is [rk:" + routeKey + "][" + message + "]";
					rabbitTemplate.send("topic-exchange", routeKey,
							new Message(str.getBytes(), new MessageProperties()));
				}
			}
			opt = "suc";
		} catch (Exception e) {
			opt = e.getCause().toString();
		}
		return opt;
	}
	
}

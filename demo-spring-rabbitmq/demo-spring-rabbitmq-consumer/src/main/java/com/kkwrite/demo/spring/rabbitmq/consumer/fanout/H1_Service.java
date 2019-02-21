package com.kkwrite.demo.spring.rabbitmq.consumer.fanout;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/** 
 * 类说明 
 *
 * @author Soosky Wang
 * @date 2018年10月12日 上午10:21:00 
 * @version 1.0.0
 */
public class H1_Service implements MessageListener {

	@Override
	public void onMessage(Message message) {
		String content = new String(message.getBody());
		System.out.println(content);
	}

}

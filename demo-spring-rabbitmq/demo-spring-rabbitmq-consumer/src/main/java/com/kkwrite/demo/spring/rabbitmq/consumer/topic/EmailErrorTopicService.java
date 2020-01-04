package com.kkwrite.demo.spring.rabbitmq.consumer.topic;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * 动脑学院-Mark老师
 * 创建日期：2017/11/07
 * 创建时间: 20:59
 */
@Component
public class EmailErrorTopicService implements MessageListener{
    
    public void onMessage(Message message) {
        System.out.println("Get message:"+new String(message.getBody()));
    }
    
}

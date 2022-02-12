package com.chen.demo.rabbitmq.exchange;

import com.chen.demo.util.RabbitMqUtils;
import com.rabbitmq.client.Channel;

public class Topic1 {
    public static final String EXCHANGE_NAME = "r_three";
    public static void main(String[] args) throws Exception{
        Channel channel = RabbitMqUtils.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        String queue = channel.queueDeclare().getQueue();
        
    }
}

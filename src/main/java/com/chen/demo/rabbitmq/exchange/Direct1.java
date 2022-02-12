package com.chen.demo.rabbitmq.exchange;

import com.chen.demo.util.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

public class Direct1 {
    public static final String EXCHANGE_NAME = "r_two";
    public static void main(String[] args) throws Exception{
        Channel channel = RabbitMqUtils.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue, EXCHANGE_NAME, "a1");
        channel.queueBind(queue, EXCHANGE_NAME, "a2");

        System.out.println("等待消息1");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("控制台打印接收到的消息"+message);
        };

        channel.basicConsume(queue, deliverCallback, consumerTag -> {});
    }
}

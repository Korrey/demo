package com.chen.demo.rabbitmq.simple;

import com.chen.demo.util.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.io.IOException;

public class Consumer {
    public static final String QUEUE_NAME = "test01";

    public static void main(String[] args) throws Exception{
        Channel channel = RabbitMqUtils.getChannel();
        DeliverCallback deliverCallback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                try {
//                    Thread.sleep(1000);
                    System.out.println("接收到消息:" + new String(message.getBody()));
                    channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        CancelCallback cancelCallback=(consumerTag)->{
            System.out.println("消息消费被中断");
        };

        System.out.println("消费者1时间等待...");

//        int prefetchCount = 2;
//        channel.basicQos(prefetchCount);

        boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME, autoAck, deliverCallback, cancelCallback);
    }
}

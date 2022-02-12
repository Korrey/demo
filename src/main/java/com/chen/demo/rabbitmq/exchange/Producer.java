package com.chen.demo.rabbitmq.exchange;

import com.chen.demo.util.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.util.Scanner;

public class Producer {
    public static final String EXCHANGE_NAME = "r_two";
    public static void main(String[] args) throws Exception{
        Channel channel = RabbitMqUtils.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            channel.basicPublish(EXCHANGE_NAME, "a2", null, s.getBytes());
            System.out.println("消息发送" + s);
        }
    }
}

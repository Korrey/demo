package com.chen.demo.rabbitmq.d_letter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class DeadLetterQueueConsumer {

    @RabbitListener(queues = "QD")
    public void receive(Message message) {
        log.info("当前时间：{},收到死信队列信息{}", new Date().toString(), new String(message.getBody()));
    }


}

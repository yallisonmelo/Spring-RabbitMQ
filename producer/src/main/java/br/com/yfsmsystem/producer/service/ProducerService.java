package br.com.yfsmsystem.producer.service;

import br.com.yfsmsystem.producer.dto.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Value("{produce.queue.first}")
    private String firstQueue;

    @Value("{produce.queue.second}")
    private String secondQueue;

    public String sendNewMessageService(Message message) {
        rabbitTemplate.convertAndSend(firstQueue, message);
        return "mail";
    }


    public String sendNewSmsService(Message message) {
        rabbitTemplate.convertAndSend(secondQueue, message);
        return "sms";
    }
}

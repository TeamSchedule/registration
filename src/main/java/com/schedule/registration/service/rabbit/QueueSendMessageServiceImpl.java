package com.schedule.registration.service.rabbit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.schedule.registration.model.external.SendEmailRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueueSendMessageServiceImpl implements QueueSendMessageService {
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @Override
    public void send(SendEmailRequest sendEmailRequest) {
        rabbitTemplate.convertAndSend(
                queue.getName(),
                objectMapper.writeValueAsString(sendEmailRequest)
        );
    }
}

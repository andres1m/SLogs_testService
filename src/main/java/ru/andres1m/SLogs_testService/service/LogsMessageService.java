package ru.andres1m.SLogs_testService.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class LogsMessageService {
    private final RabbitTemplate template;

    @Value("${spring.application.name}")
    private String serviceName;

    public void sendLogsMessage(String message) {
        try {
            String json = new ObjectMapper().writeValueAsString(Map.of("name", serviceName, "message", message));
            template.convertAndSend("logsMessage", json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
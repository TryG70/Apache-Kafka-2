package com.trygod.kafkatutorial.controller;

import com.google.gson.Gson;
import com.trygod.kafkatutorial.data.Message;
import com.trygod.kafkatutorial.dto.MessageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson gson;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate, Gson gson) {
        this.kafkaTemplate = kafkaTemplate;
        this.gson = gson;
    }

    @PostMapping
    public void sendMessage(@RequestBody MessageRequest messageRequest) {

        String message = gson.toJson(messageRequest);
        kafkaTemplate.send("${spring.kafka.template.default-topic}", message);
    }
}

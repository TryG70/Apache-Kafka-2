package com.trygod.kafkatutorial.listener;

import com.google.gson.*;
import com.trygod.kafkatutorial.data.Message;
import com.trygod.kafkatutorial.dto.MessageRequest;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class KafkaListeners {

    private final Gson gson;


    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-id}")
    void listener(String data) {

        MessageRequest messageRequest = gson.fromJson(data, MessageRequest.class);

        Message message = new Message(messageRequest.getMessage(), LocalDateTime.parse(messageRequest.getCreatedAt()));
        System.out.println("Listener Received: " + message);
    }
}

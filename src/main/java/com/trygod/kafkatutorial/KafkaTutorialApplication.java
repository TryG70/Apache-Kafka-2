package com.trygod.kafkatutorial;

import com.google.gson.Gson;
import com.trygod.kafkatutorial.data.Message;
import com.trygod.kafkatutorial.dto.MessageRequest;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
@AllArgsConstructor
public class KafkaTutorialApplication {

    private final Gson gson;

    public static void main(String[] args) {
        SpringApplication.run(KafkaTutorialApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner (KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {

            for (int i = 0; i < 10; i++) {

                Message message = new Message("Hello again Kafka :)", LocalDateTime.now());
                MessageRequest messageRequest = new MessageRequest(message.getMessage(), message.getCreatedAt().toString());
                String gson2 = gson.toJson(messageRequest);

                kafkaTemplate.send("trygod", gson2);
            }
        };
    }

}

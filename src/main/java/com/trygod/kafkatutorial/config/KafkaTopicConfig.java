package com.trygod.kafkatutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {


    @Bean
    public NewTopic topicConfig() {
        return TopicBuilder.name("trygod")
                .build();
    }

//    // Use this when you have to build multiple configs
//    @Bean
//    public KafkaAdmin.NewTopics topicConfigs() {
//        return new KafkaAdmin.NewTopics(
//                TopicBuilder.name("trygod")
//                        .build(),
//                TopicBuilder.name("trygod")
//                        .build()
//        );
//    }

}

package com.Stream1.KafkaStream1;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class Config {
    @Bean
    NewTopic topic(){
        return TopicBuilder.name("output").build();
    }

}

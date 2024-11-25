package com.Stream1.KafkaStream1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
@EnableKafkaStreams
public class KafkaStream1Application {

	public static void main(String[] args) {
		SpringApplication.run(KafkaStream1Application.class, args);
	}

}

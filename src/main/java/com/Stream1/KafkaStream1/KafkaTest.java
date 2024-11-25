package com.Stream1.KafkaStream1;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.stereotype.Component;

@Component
public class KafkaTest {
    
    @Bean(name = "defaultKafkaStreamsConfig")
    public KafkaStreamsConfiguration kafkaStreamsConfiguration() {
        Map<String, Object> map = new HashMap<>();
        map.put(StreamsConfig.APPLICATION_ID_CONFIG, "test1");
        map.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        map.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        map.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        return new KafkaStreamsConfiguration(map);

    }

    @Bean
    public KStream<String, String> test(StreamsBuilder builder) {
        KStream<String, String> stream = builder.stream("input", Consumed.with(Serdes.String(), Serdes.String()));
        stream.mapValues((message) -> {System.out.println(message); return message.toUpperCase();}).to("output");
        return stream;
    }
}

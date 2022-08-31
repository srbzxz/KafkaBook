package com.example.kafkabook;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class KafkaBookApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(KafkaBookApplication.class, args);
        KafkaProducer<String, String> producer = context.getBean(KafkaProducer.class);

        ProducerRecord<String, String> record = new ProducerRecord<>("CustomerCountry", "Precision Products", "France");
        RecordMetadata recordMetadata = null;
        try {
            recordMetadata = producer.send(record).get();
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }

}

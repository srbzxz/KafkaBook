package com.example.kafkabook;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class BookProducerCallback implements Callback {

    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        System.out.println(recordMetadata);
        if (e != null) {
            e.printStackTrace();
        }
    }
}

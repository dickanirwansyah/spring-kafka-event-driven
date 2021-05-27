package id.dicka.corp.kafkaconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HelloKafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(HelloKafkaConsumer.class);

    //@KafkaListener(topics = "hello", groupId = "group_id")
    public void consumeMessage(String message) throws IOException {
        log.info(String.format("### -> Consumed message -> %s ",message));
    }
}

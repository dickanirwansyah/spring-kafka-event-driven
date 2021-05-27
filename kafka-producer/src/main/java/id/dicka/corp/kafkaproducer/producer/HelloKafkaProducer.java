package id.dicka.corp.kafkaproducer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class HelloKafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(HelloKafkaProducer.class);
    private static final String TOPIC = "hello";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    //@PostConstruct
    public void sendMessage(){
        String message = "Hello first kafka ke-";
        for (int i=0; i < 100; i++){
            log.info(String.format("### -> Producing message message -> %s", message+i));
            this.kafkaTemplate.send(TOPIC, message+i);
        }
    }
}

package id.dicka.corp.kafkaconsumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaKeyConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaKeyConsumer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "t_multi_partitions")
    public void consume(ConsumerRecord<String, String> message){
        log.info("KEY : {} , PARTITIONS : {} , MESSAGE : {} ",
                message.key(),
                message.partition(),
                message.value());
    }
}

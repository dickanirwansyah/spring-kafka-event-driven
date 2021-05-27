package id.dicka.corp.kafkaproducer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class KafkaKeyProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaKeyProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    //@PostConstruct
    public void sendMessage(){
        for (int i=0; i < 30; i++){
             var key = "key - "+(i%4);
             var data = "data "+i+" with key "+key;
             log.info("this : "+key+" & "+data);
             kafkaTemplate.send("t_multi_partitions", key, data);
        }
    }
}

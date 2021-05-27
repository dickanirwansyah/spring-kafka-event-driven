package id.dicka.corp.kafkaconsumer.consumer;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.dicka.corp.kafkaconsumer.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaJsonConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "t_product")
    public void consumeJson(String message) throws JsonParseException, JsonMappingException, IOException {
         var productJson = objectMapper.readValue(message, Product.class);
         log.info("CONSUME : "+productJson);
    }
}

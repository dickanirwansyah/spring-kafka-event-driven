package id.dicka.corp.kafkaproducer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.dicka.corp.kafkaproducer.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.UUID;

@Service
public class KafkaJsonProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaJsonProducer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostConstruct
    public void sendMessage() throws JsonProcessingException {

        for (int i=0; i < 10; i++){
            Product product = new Product();
            product.setId(UUID.randomUUID().toString());
            product.setProductId("P+"+UUID.randomUUID().toString());
            product.setProductName("apple watch version "+i);
            product.setPrice(new BigDecimal(Math.random()));
            product.setQty(i+1);

            var jsonData = objectMapper.writeValueAsString(product);
            log.info("DATA PRODUCT : "+jsonData);
            kafkaTemplate.send("t_product", jsonData);
        }

    }

}

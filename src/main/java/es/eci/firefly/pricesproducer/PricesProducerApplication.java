package es.eci.firefly.pricesproducer;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.eci.firefly.pricesproducer.model.Price;
import es.eci.firefly.pricesproducer.service.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class PricesProducerApplication implements CommandLineRunner {

    private final Producer producer;
    private final ObjectMapper mapper;

    @Autowired
    PricesProducerApplication(Producer producer, ObjectMapper mapper) {
        this.producer = producer;
        this.mapper = mapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(PricesProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Application started with command-line arguments: {} . \n To kill this application, press Ctrl + C.",
                Arrays.toString(args));
        Price priceXboxPesetas = Price.builder().item("Xbox 360").company("ECI").value(44999.00).
                commercialCenterCode("232").build();
        this.producer.sendMessage(mapper.writeValueAsString(priceXboxPesetas));
    }
}

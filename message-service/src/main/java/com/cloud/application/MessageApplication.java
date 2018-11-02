package com.cloud.application;


import com.cloud.kafka.producer.Sender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by harbor on 11/1/2018.
 */
@SpringBootApplication
@ComponentScan("com.cloud")
public class MessageApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MessageApplication.class, args);
        Sender sender =  context.getBean(Sender.class);
        sender.send("Spring Kafka Producer and Consumer Example");

    }

}

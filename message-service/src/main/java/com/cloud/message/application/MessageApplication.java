package com.cloud.message.application;


//import com.cloud.message.kafka.producer.Sender;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by harbor on 11/1/2018.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@ComponentScan(basePackages = {"com.cloud.message"})
@EnableFeignClients(basePackages = {"com.cloud.message.feign.client"})
public class MessageApplication {

    public static void main(String[] args) {
//        ConfigurableApplicationContext context =
        SpringApplication.run(MessageApplication.class, args);
//        Sender sender =  context.getBean(Sender.class);
//        sender.send("Spring Kafka Producer and Consumer Example");
    }


    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cloud.message"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Message API").description("Message Notification API v1.0").build());
    }

//    @Bean
//    public StringJsonMessageConverter converter() {
//        return new StringJsonMessageConverter();
//    }

}

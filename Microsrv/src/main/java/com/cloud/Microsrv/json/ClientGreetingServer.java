package com.cloud.Microsrv.json;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false) // Disable component scanner
public class ClientGreetingServer {
 
    public static final String SERVICE_URL = "http://GREETING-SERVICE";
 
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "greeting-client");
        SpringApplication.run(ClientGreetingServer.class, args);
    }
 
    // The service encapsulates the interaction with the micro-service.
    @Bean
    public ClientGreetingService helloWorldService() {
        return new ClientGreetingService(SERVICE_URL);
    }
 
    //Create the controller, passing it the ClientGreetingService to use.
    @Bean
    public ClientGreetingController helloWorldController() {
        return new ClientGreetingController(helloWorldService());
    }
 
    @Bean
    public ClientGreetingHomeController homeController() {
        return new ClientGreetingHomeController();
    }
}
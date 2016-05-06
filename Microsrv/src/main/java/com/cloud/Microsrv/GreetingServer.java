package com.cloud.Microsrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class GreetingServer {
 
    public static void main(String[] args) {
 
        // Tell server to look for greeting-server.yml
        System.setProperty("spring.config.name", "greeting-server");
        SpringApplication.run(GreetingServer.class, args);
    }
}

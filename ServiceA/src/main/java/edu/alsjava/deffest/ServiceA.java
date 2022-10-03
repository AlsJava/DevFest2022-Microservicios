package edu.alsjava.deffest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceA {

    public static void main(String[] args) {
        SpringApplication.run(ServiceA.class, args);
    }
}

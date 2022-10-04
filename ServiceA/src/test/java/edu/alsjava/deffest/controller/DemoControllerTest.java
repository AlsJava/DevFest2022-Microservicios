package edu.alsjava.deffest.controller;

import edu.alsjava.deffest.model.network.request.CalculateFactorialRequest;
import edu.alsjava.deffest.model.network.request.CreateUserRequest;
import edu.alsjava.deffest.model.network.response.CalculateFactorialResponse;
import edu.alsjava.deffest.model.network.response.CreateUserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoControllerTest {

    @Autowired
    private WebClient.Builder builder;

    private WebClient webClient;

    @BeforeEach
    void setup() {
        this.webClient = builder.baseUrl("http://localhost:8090/demo").build();
    }

    @Tag("Network")
    @Test
    void demoTest() {
        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .name("Demo")
                .build();
        CreateUserResponse createUserResponse = webClient.post().uri("/create").accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(createUserRequest))
                .exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(CreateUserResponse.class);
                    }
                    return Mono.empty();
                }).block();
        assertNotNull(createUserResponse);
        System.out.println(createUserRequest);
        System.out.println(createUserResponse);
    }

    @Tag("Network")
    @Test
    void factorialTest() {
        CalculateFactorialRequest calculateFactorialRequest = CalculateFactorialRequest.builder()
                .num(8)
                .build();
        CalculateFactorialResponse calculateFactorialResponse = webClient.post().uri("/factorial").accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(calculateFactorialRequest))
                .exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(CalculateFactorialResponse.class);
                    }
                    return Mono.empty();
                }).block();
        assertNotNull(calculateFactorialResponse);
        System.out.println(calculateFactorialRequest);
        System.out.println(calculateFactorialResponse);
        assertEquals(40320, calculateFactorialResponse.getFactorial());
    }

}
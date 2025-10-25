
package org.springframework.rest.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class SampleController {

    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    private final WebClient webClient;

    public SampleController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8000").build();
    }

    @GetMapping("/hello")
    public Mono<String> hello() {
        logger.info("request(GET) hello method.");
        return Mono.just("Hello,Flux.");
    }

    @GetMapping("/python")
    public Mono<String> python() {
        logger.info("request(GET) python method.");
        return this.webClient.get().uri("/").retrieve().bodyToMono(String.class);
    }
}

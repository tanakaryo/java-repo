package com.example.demo;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @GetMapping("/startFileMove")
    public String startFileMove() {
        producerTemplate.sendBody("direct:fileMoveRoute", "Sample Content");
        return "File move process started!";
    }
}

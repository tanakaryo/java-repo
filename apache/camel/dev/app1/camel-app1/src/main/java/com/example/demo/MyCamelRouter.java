package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyCamelRouter extends RouteBuilder {

    @Autowired
    MyBean myBean;

    @Override
    public void configure() throws Exception {
        from("timer:hello?period={{myPeriod}}").routeId("hello")
        .bean(myBean, "saySomething")
        .to("stream:out");

        from("direct:fileMoveRoute")
        .log("Processing file: ${file:name}")
        .to("file:/Users/user/Documents/github/java-repo/apache/camel/dev/app1/camel-app1/camel-dest?fileName=${file:name.noext}.bak");
    }

}

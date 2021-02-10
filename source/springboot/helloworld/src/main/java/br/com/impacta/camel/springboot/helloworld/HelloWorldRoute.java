package br.com.impacta.camel.springboot.helloworld;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:example?period=1000000000")
            .log("Hello World");
    }

}

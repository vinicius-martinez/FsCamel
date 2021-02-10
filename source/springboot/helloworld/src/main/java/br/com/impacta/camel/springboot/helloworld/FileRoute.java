package br.com.impacta.camel.springboot.helloworld;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:/tmp/input")
            .log("FileName: ${in.header.CamelFileName} Content: ${body}")
            .convertBodyTo(java.lang.String.class)
            .bean(UpperBean.class, "upperCase")
            .to("file:/tmp/output?fileName=${date:now:yyyyMMddhhmmss}.txt.done");
    }
}


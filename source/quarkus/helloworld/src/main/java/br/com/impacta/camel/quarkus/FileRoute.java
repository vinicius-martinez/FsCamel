package br.com.impacta.camel.quarkus;

import org.apache.camel.builder.RouteBuilder;

public class FileRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:/tmp/input-quarkus")
            .log("FileName: ${in.header.CamelFileName} Content: ${body}")
            .log("FileName: ${in.header.CamelFileName} Content: ${body}")
            .convertBodyTo(java.lang.String.class)
            .bean(UpperBean.class, "upperCase")
            .to("file:/tmp/output-quarkus?fileName=${date:now:yyyyMMddhhmmss}.txt.done");
    }
}

package br.com.impacta.camel.springboot.helloworld;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerRoute extends RouteBuilder {

    @Autowired
    CustomerService customerService;

    @Override
    public void configure() throws Exception {
        restConfiguration().host("localhost").port(8080).bindingMode(RestBindingMode.json);
        rest("/customers")
            .post("/").consumes("application/json").type(Customer.class).route().bean(customerService, "addCustomer(${body})").endRest()
            .get("/").produces("application/json").route().bean(customerService, "listCustomer").endRest()
            .get("/{id}").route().bean(customerService, "getCustomer(${header.id})").endRest()
            .put("/").consumes("application/json").type(Customer.class).route().bean(customerService, "updateCustomer(${body})").endRest()
            .delete("/{id}").produces("application/json").route().bean(customerService, "deleteCustomer(${header.id})").endRest();
    }
}

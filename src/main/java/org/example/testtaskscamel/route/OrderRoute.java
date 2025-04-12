package org.example.testtaskscamel.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.example.testtaskscamel.entities.Orders;
import org.example.testtaskscamel.filters.OrderFilter;
import org.springframework.stereotype.Component;

@Component
public class OrderRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        //json->pojo
        from("file:src/main/resources/input?noop=true").
                log("file name:\n ${header.CamelFileName}").
                log("file body:\n ${body}").
                unmarshal().json(JsonLibrary.Jackson, Orders.class).
                log("json body: ${body}").
        //filters
                filter().method(OrderFilter.class, "isNullId").
                marshal().json(JsonLibrary.Jackson).
                log("send to errors").
                to("file:src/main/resources/errors").
                stop().
                end().

                filter().method(OrderFilter.class, "isNullCustomer").
                marshal().json(JsonLibrary.Jackson).
                log("send to errors").
                to("file:src/main/resources/errors").
                stop().
                end().

                filter().method(OrderFilter.class, "isNullName").
                marshal().json(JsonLibrary.Jackson).
                log("send to errors").
                to("file:src/main/resources/errors").
                stop().
                end().

                filter().method(OrderFilter.class, "isPriceInvalid").
                marshal().json(JsonLibrary.Jackson).
                log("send to errors").
                to("file:src/main/resources/errors").
                stop().
                end().
        //pojo->xml
                marshal().jacksonXml().
                to("xslt:convert.xsl").
                log("xml body:\n ${body}").
        //send to api
                setHeader(Exchange.CONTENT_TYPE, constant("application/xml")).
                log("send to api: ${body}").
                to("http://localhost:8080/orders").
                log("send to processed").
                to("file:src/main/resources/processed").
                log("finish success");
    }
}

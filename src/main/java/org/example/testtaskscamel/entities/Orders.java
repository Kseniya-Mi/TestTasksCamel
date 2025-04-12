package org.example.testtaskscamel.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Orders {

    @JsonProperty("orderId")
    private int orderId;

    @JsonProperty("customer")
    private String customer;

    @JsonProperty("items")
    private List<Items> items;

    public int getOrderId(){
        return orderId;
    }

    public String getCustomer(){
        return customer;
    }

    public List<Items> getItems(){
        return items;
    }
}

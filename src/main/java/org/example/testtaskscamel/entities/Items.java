package org.example.testtaskscamel.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Items {

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

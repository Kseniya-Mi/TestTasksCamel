package org.example.testtaskscamel.filters;

import org.example.testtaskscamel.entities.Orders;
import org.springframework.stereotype.Component;

@Component
public class OrderFilter {

    public boolean isNullId(Orders order){
        return order.getOrderId() == 0;
    }

    public boolean isNullCustomer(Orders order){
        return order.getCustomer().isEmpty();
    }

    public boolean isNullName(Orders order){
        return order.getItems().isEmpty();
    }

    public boolean isPriceInvalid(Orders order){
        return order.getItems().stream().allMatch(item -> item.getPrice() <= 0);
    }
}

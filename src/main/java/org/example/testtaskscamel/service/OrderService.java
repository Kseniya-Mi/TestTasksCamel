package org.example.testtaskscamel.service;

import org.example.testtaskscamel.entities.Orders;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final List<Orders> list = new ArrayList<>();

    public Orders addOrder(Orders order) {
        list.add(order);
        return order;
    }

    public List<Orders> getOrders() {
        return list;
    }
}

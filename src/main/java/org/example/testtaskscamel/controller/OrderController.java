package org.example.testtaskscamel.controller;

import org.example.testtaskscamel.entities.Orders;
import org.example.testtaskscamel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

        private final OrderService orderService;

        @Autowired
        public OrderController(OrderService orderService) {
            this.orderService = orderService;
        }

        @PostMapping(consumes = "application/xml")
        public String receiveOrder(@RequestBody Orders order) {
            orderService.addOrder(order);
            return "Sent successfully";
        }

        @GetMapping
        public List<Orders> getOrders() {
            return orderService.getOrders();
        }
}

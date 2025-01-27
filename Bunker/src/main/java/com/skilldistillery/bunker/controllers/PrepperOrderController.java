package com.skilldistillery.bunker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bunker.entities.PrepperOrder;
import com.skilldistillery.bunker.services.PrepperOrderService;

@RestController
@RequestMapping("api/orders")
public class PrepperOrderController {

    @Autowired
    private PrepperOrderService orderService;

    @GetMapping
    public List<PrepperOrder> listAllOrders() {
        return orderService.findAll();
    }

    @PostMapping
    public PrepperOrder createOrder(@RequestBody PrepperOrder order) {
        return orderService.create(order);
    }

    @PutMapping("/{id}")
    public PrepperOrder updateOrder(@PathVariable int id, @RequestBody PrepperOrder order) {
        return orderService.update(id, order);
    }

    @DeleteMapping("/{id}")
    public boolean deleteOrder(@PathVariable int id) {
        return orderService.deleteById(id);
    }
}

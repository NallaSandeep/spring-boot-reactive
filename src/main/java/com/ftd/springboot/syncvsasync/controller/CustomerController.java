package com.ftd.springboot.syncvsasync.controller;

import com.ftd.springboot.syncvsasync.dto.Customer;
import com.ftd.springboot.syncvsasync.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping(value = "/stream")
    public Flux<Customer> getCustomersStream() {
        return customerService.getCustomersStream();
    }

    @GetMapping(value = "/event-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getCustomersTextEventStream() {
        return customerService.getCustomersStream();
    }
}

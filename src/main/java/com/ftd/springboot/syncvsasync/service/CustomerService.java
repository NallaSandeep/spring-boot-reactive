package com.ftd.springboot.syncvsasync.service;

import com.ftd.springboot.syncvsasync.dao.CustomerDao;
import com.ftd.springboot.syncvsasync.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    public Flux<Customer> getCustomersStream() {
        return customerDao.getCustomersStream();
    }
}

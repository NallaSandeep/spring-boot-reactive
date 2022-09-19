package com.ftd.springboot.syncvsasync.dao;

import com.ftd.springboot.syncvsasync.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    public List<Customer> getCustomers() {
        return IntStream.rangeClosed(1,10)
                .peek(this::sleep)
                .peek(i-> System.out.println("Processing element "+ i))
                .mapToObj(i->Customer.builder().id(i).name("Customer"+i).build())
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomersStream() {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i-> System.out.println("Processing element "+ i))
                .map(i->Customer.builder().id(i).name("Customer"+i).build());
    }

    public void sleep(Integer i)  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

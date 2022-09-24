package com.ftd.springboot.javabrains.test;

import com.ftd.springboot.javabrains.streams.ReactiveStreams;
import reactor.core.publisher.Flux;

import java.io.IOException;

public class BadPractices {

    public static void main(String[] args) throws IOException {
        Flux<Integer> integerFlux = ReactiveStreams.intFlux();
        /*Bad practice*/
        integerFlux.filter(i -> i > 5);
        integerFlux.map(i -> i * 10);
        integerFlux.subscribe(System.out::println);

        /*Good practice*/
        Flux<Integer> filter = integerFlux.filter(i -> i > 5);
        Flux<Integer> map = filter.map(i -> i * 10);
        map.subscribe(System.out::println);

        System.out.println("Press Enter key to terminate");
        System.in.read();
    }
}

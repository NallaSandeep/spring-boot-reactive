package com.ftd.springboot.webflux.reactive;

import reactor.core.publisher.Flux;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FluxEx {

    /**
     * Flux emits zero or more elements
     */
    public static void main(String[] args) {
        Flux.fromIterable(Stream.of("Spring", "Reactive").collect(Collectors.toList()))
                .subscribe(System.out::println);
    }
    /**
    Output:
        Spring
        Reactive
    */
}

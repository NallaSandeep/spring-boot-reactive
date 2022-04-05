package com.ftd.springboot.webflux.reactive;

import reactor.core.publisher.Mono;

public class MonoEx {

    public static void main(String[] args) {
        Mono.justOrEmpty("Spring")
                .subscribe(System.out::println);
    }

    // Output:
    // Spring
}

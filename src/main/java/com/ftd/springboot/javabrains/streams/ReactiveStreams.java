package com.ftd.springboot.javabrains.streams;

import com.ftd.springboot.javabrains.dao.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ReactiveStreams {

    public static Flux<Integer> intFlux() {
        return Flux.range(1,10).delayElements(Duration.ofSeconds(1));
    }

    public static Flux<User> userFlux() {
        return Flux.range(1,10).map(i -> new User(i, "User"+i)).delayElements(Duration.ofSeconds(1));
    }

    public static Flux<Integer> unresponsiveFlux() {
        return Flux.never();
    }

    public static Mono<Integer> unresponsiveMono() {
        return Mono.never();
    }

    public static Mono<Integer> intMono() {
        return Mono.just(1);
    }
}

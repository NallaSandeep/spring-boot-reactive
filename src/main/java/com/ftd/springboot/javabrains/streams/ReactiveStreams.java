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

    public static Flux<Integer> emptyFlux() {
        return Flux.empty();
    }

    public static Flux<Integer> intFluxWithRepeat() {
        return Flux
                .just(1, 2, 1, 1, 3, 2, 4, 5, 1)
                .delayElements(Duration.ofSeconds(1));
    }

    public static Flux<User> userFluxWithRepeat() {
        return Flux
                .just(User.builder().id(1).name("User1").build(),
                        User.builder().id(2).name("User2").build(),
                        User.builder().id(1).name("User1").build(),
                        User.builder().id(1).name("User1").build(),
                        User.builder().id(3).name("User3").build(),
                        User.builder().id(2).name("User2").build(),
                        User.builder().id(4).name("User4").build(),
                        User.builder().id(5).name("User5").build(),
                        User.builder().id(1).name("User1").build())
                .delayElements(Duration.ofSeconds(1));
    }

    public static Mono<Integer> unresponsiveMono() {
        return Mono.never();
    }

    public static Mono<Integer> intMono() {
        return Mono.just(1);
    }
}

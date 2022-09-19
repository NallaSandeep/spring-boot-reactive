package com.ftd.springboot.javabrains.streams;

import com.ftd.springboot.javabrains.dao.User;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class ReactiveStreams {

    public static Flux<Integer> intStream() {
        return Flux.range(1,10).delayElements(Duration.ofSeconds(1));
    }

    public static Flux<User> userStream() {
        return Flux.range(1,10).map(i -> new User(i, "User"+i)).delayElements(Duration.ofSeconds(1));
    }
}

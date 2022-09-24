package com.ftd.springboot.javabrains.test;

import com.ftd.springboot.javabrains.streams.ReactiveStreams;
import reactor.core.publisher.Flux;

import java.io.IOException;

public class SubscribeTest {

    public static void main(String[] args) throws IOException {
        /*Below two streams run asynchronously*/
        ReactiveStreams.intFlux().subscribe(i -> System.out.println(i));
        ReactiveStreams.userFlux().subscribe(u -> System.out.println(u));

        /*A single stream is subscribed twice. They run asynchronously*/
        Flux<Integer> integerFlux = ReactiveStreams.intFlux();
        integerFlux.subscribe(i-> System.out.println(i));
        integerFlux.subscribe(i-> System.out.println("Another: " + i));
        Flux<Integer> intFlux = ReactiveStreams.intFlux();

        /*subscribe overloaded methods*/
        intFlux.subscribe();
        integerFlux.subscribe(System.out::println);
        intFlux.subscribe(System.out::println, throwable -> System.out.println(throwable.getMessage()));
        intFlux.subscribe(System.out::println, throwable -> System.out.println(throwable.getMessage()),
                () -> System.out.println("Complete"));

        System.out.println("Press Enter key to terminate");
        System.in.read();
    }
}

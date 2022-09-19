package com.ftd.springboot.javabrains.test;

import com.ftd.springboot.javabrains.streams.ReactiveStreams;
import reactor.core.publisher.Flux;

import java.io.IOException;

public class SubscribeTest {

    public static void main(String[] args) throws IOException {
        /*ReactiveStreams.intStream().subscribe(i -> System.out.println(i));
        ReactiveStreams.userStream().subscribe(u -> System.out.println(u));*/
        Flux<Integer> integerFlux = ReactiveStreams.intStream();
        integerFlux.subscribe(i-> System.out.println(i));
        integerFlux.subscribe(i-> System.out.println("Another: " + i));
        System.out.println("Press any key to terminate");
        System.in.read();
    }
}

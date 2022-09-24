package com.ftd.springboot.javabrains.test;

import com.ftd.springboot.javabrains.streams.ReactiveStreams;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BlockStream {

    public static void main(String[] args) throws IOException {
        /*Blocking Flux*/
        List<Integer> blockedList = ReactiveStreams.intFlux().toStream().collect(Collectors.toList());
        System.out.println(blockedList);

        /*Blocking Mono*/
        Integer integer = ReactiveStreams.intMono().block();
        System.out.println(integer);

        /*Blocking Flux*/
        List<Integer> unrespList = ReactiveStreams.unresponsiveFlux().timeout(Duration.ofSeconds(5)).toStream().collect(Collectors.toList());
        System.out.println(unrespList);

        /*Blocking unresponsive Mono*/
        Integer unresInt = ReactiveStreams.unresponsiveMono().block(Duration.ofSeconds(5));
        System.out.println(unresInt);

        System.out.println("Press Enter key to terminate");
        System.in.read();
    }
}

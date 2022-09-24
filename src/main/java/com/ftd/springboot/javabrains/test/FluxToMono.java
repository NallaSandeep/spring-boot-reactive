package com.ftd.springboot.javabrains.test;

import com.ftd.springboot.javabrains.streams.ReactiveStreams;

import java.io.IOException;

public class FluxToMono {

    public static void main(String[] args) throws IOException {
        /*count*/
        ReactiveStreams.intFlux()
                .count()
                .log()
                .subscribe();

        /*collectList*/
        ReactiveStreams.intFlux()
                        .collectList()
                        .log()
                        .subscribe();

        ReactiveStreams.intFlux()
                        .buffer(2)
                        .map(l -> l.get(0) + l.get(1))
                        .log()
                        .subscribe();

        System.out.println("Press Enter key to terminate");
        System.in.read();
    }
}

package com.ftd.springboot.javabrains.test;

import com.ftd.springboot.javabrains.dao.User;
import com.ftd.springboot.javabrains.streams.ReactiveStreams;

import java.io.IOException;

public class Operators {

    public static void main(String[] args) throws IOException {
        /*filter operator*/
        ReactiveStreams.intFlux()
                .filter(i -> i > 5)
                .subscribe(System.out::println);

        /*log operator*/
        ReactiveStreams.intFlux()
                        .log()
                        .filter(i -> i > 5)
                        .subscribe(System.out::println);

        /*Map operator*/
        ReactiveStreams.intFlux()
                        .map(i -> i * 10)
                        .log()
                        .subscribe();

        /*take operator*/
        ReactiveStreams.intFlux()
                .filter(i -> i > 5)
                .take(3)
                .map(i -> i * 10)
                .log()
                .subscribe();

        /*defaultIfEmpty operator*/
        ReactiveStreams.emptyFlux()
                        .defaultIfEmpty(-1)
                        .log()
                        .subscribe();

        ReactiveStreams.intFlux()
                .filter(i -> i > 20)
                .defaultIfEmpty(-1)
                .log()
                .subscribe();

        /*flatMap operator*/
        ReactiveStreams.intFlux()
                        .filter(i -> i > 2 && i < 7)
                        .flatMap(i -> ReactiveStreams.userFlux().filter(u -> u.getId().equals(i)).take(1))
                        .defaultIfEmpty(User.builder().build())
                        .log()
                        .subscribe();

        /*distinct operator*/
        ReactiveStreams.intFluxWithRepeat()
                        .distinct()
                        .log()
                        .subscribe();

        ReactiveStreams.userFluxWithRepeat()
                        .distinct()
                        .log()
                        .subscribe();

        /*distinctUntilChanged operator*/
        ReactiveStreams.intFluxWithRepeat()
                .distinctUntilChanged()
                .log()
                .subscribe();

        ReactiveStreams.userFluxWithRepeat()
                        .distinctUntilChanged()
                        .log()
                        .subscribe();

        System.out.println("Press Enter key to terminate");
        System.in.read();
    }
}

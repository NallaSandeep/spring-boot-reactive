package com.ftd.springboot.javabrains.test;

import com.ftd.springboot.javabrains.streams.ReactiveStreams;
import reactor.core.publisher.Flux;

import java.io.IOException;

public class ErrorHandling {

    public static void main(String[] args) throws IOException {
        /*doOnError */
        ReactiveStreams.intFluxWithError()
                        .doOnError(e -> System.out.println("Error occurred: " + e.getMessage()))
                        .log()
                        .subscribe();

        /*onErrorContinue */
        ReactiveStreams.intFluxWithError()
                .onErrorContinue((e, item) -> System.out.println("Error occurred with " + item + ": " + e.getMessage()))
                .log()
                .subscribe();

        /*onErrorResume*/
        ReactiveStreams.intFluxWithError()
                .onErrorResume(e -> Flux.just(-1, -2))
                .log()
                .subscribe();

        /*onErrorMap*/
        ReactiveStreams.intFluxWithError()
                .onErrorMap(e -> new IOException("test"))
                .log()
                .subscribe();

        /*onErrorStop - onErrorContinue doesn't work in down streams*/
        Flux<Integer> fluxWithError = ReactiveStreams.intFluxWithError()
                .onErrorStop()
                .log();
        fluxWithError
                .onErrorContinue((e, item) -> System.out.println("Error occurred with " + item + ": " + e.getMessage()))
                .subscribe();

        System.out.println("Press Enter key to terminate");
        System.in.read();
    }
}

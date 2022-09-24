package com.ftd.springboot.javabrains.test;

import com.ftd.springboot.javabrains.streams.ReactiveStreams;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

import java.io.IOException;

public class ErrorHandling {

    public static void main(String[] args) throws IOException {

        /*subscribe error handling*/
        ReactiveStreams.intFluxWithError()
                .subscribe(System.out::println, e -> System.out.println(e.getMessage()));

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

        /*onErrorReturn */
        ReactiveStreams.intFluxWithError()
                .onErrorReturn(1)
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

        /*doFinally*/
        ReactiveStreams.intFluxWithError()
                .doFinally(signalType -> {
                    if (signalType == SignalType.ON_COMPLETE) {
                        System.out.println("Complete");
                    } else if (signalType == SignalType.ON_ERROR) {
                        System.out.println("Error");
                    }
                })
                .log()
                .subscribe();

        ReactiveStreams.intFlux()
                .doFinally(signalType -> {
                    if (signalType == SignalType.ON_COMPLETE) {
                        System.out.println("Complete");
                    } else if (signalType == SignalType.ON_ERROR) {
                        System.out.println("Error");
                    }
                })
                .log()
                .subscribe();

        System.out.println("Press Enter key to terminate");
        System.in.read();
    }
}

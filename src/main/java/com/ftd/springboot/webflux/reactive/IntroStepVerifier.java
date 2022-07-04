package com.ftd.springboot.webflux.reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntroStepVerifier {

    @Test
    public void testStepVerifier() {
        /**
         * COMMENT: Created a flux of elements
         */
        Flux<String> flux = Flux.fromIterable(Stream.of("Spring", "Reactive", "Deep", "Learning")
                .collect(Collectors.toList())).log();
        /**
         * INFO: create method acts as a subscriber
         */
        StepVerifier.create(flux)
                /**
                 * INFO: expectNext method validates the next elements
                 */
                .expectNext("Spring", "Reactive")
                /**
                 * INFO: expectNextCount method validates teh count of next elements
                 */
                .expectNextCount(2)
                /**
                 * INFO: verifyComplete method validates OnComplete status
                 */
                .verifyComplete();
    }
}

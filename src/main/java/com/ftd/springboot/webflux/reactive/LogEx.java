package com.ftd.springboot.webflux.reactive;

import reactor.core.publisher.Mono;

public class LogEx {

    public static void main(String[] args) {
        Mono.justOrEmpty("Spring")
                /**
                 * Log method prints event communication between subscriber and publisher
                 */
                .log()
                .subscribe(System.out::println);
    }

    /**
     Output:
     01:25:55.085 [main] DEBUG reactor.util.Loggers - Using Slf4j logging framework
     01:25:55.150 [main] INFO reactor.Mono.Just.1 - | onSubscribe([Synchronous Fuseable] Operators.ScalarSubscription)
     01:25:55.156 [main] INFO reactor.Mono.Just.1 - | request(unbounded)
     01:25:55.157 [main] INFO reactor.Mono.Just.1 - | onNext(Spring)
     Spring
     01:25:55.160 [main] INFO reactor.Mono.Just.1 - | onComplete()
    */
}

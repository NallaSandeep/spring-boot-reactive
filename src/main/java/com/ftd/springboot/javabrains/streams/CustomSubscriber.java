package com.ftd.springboot.javabrains.streams;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

public class CustomSubscriber<T> extends BaseSubscriber<T> {

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribed");
        request(1);
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println(value.toString());
        request(1);
    }

    @Override
    protected void hookOnComplete() {
        System.out.println("Complete");
    }
}

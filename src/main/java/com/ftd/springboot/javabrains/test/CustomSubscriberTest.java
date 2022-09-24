package com.ftd.springboot.javabrains.test;

import com.ftd.springboot.javabrains.streams.CustomSubscriber;
import com.ftd.springboot.javabrains.streams.ReactiveStreams;

import java.io.IOException;

public class CustomSubscriberTest {

    public static void main(String[] args) throws IOException {
        ReactiveStreams.intFlux().subscribe(new CustomSubscriber<>());
        System.out.println("Press Enter key to terminate");
        System.in.read();
    }
}

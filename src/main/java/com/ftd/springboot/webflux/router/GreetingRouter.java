package com.ftd.springboot.webflux.router;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.ftd.springboot.webflux.handler.GreetingHandler;

@Configuration(proxyBeanMethods = false)
public class GreetingRouter {

	public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
		return RouterFunctions.route(
				RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
				greetingHandler::hello);

	}

}

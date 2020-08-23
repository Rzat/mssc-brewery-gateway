package com.example.beerworks.brewerygateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

//@Profile("google")
//@Configuration
public class GoogleConfig {

    //just an example of routing requests  to google from localhost
    @Bean
    public RouteLocator googleRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(r -> r.path("/googlesearch2")
                        .filters(f -> f.rewritePath("/googlesearch2(?<segment>/?.*)", "/${segment}"))
                        .uri("https://google.com")
                        .id("google"))
                .build();

    }
}

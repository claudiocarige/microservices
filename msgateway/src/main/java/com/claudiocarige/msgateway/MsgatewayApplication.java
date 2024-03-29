package com.claudiocarige.msgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class MsgatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsgatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder
                .routes()
                    .route(r -> r.path("/clients/**").uri("lb://msclients"))
                    .route(r -> r.path("/cards/**").uri("lb://mscartoes"))
                    .route(r -> r.path("/credit-ratings/**").uri("lb://msavaliadorcredito"))
                .build();
    }
}

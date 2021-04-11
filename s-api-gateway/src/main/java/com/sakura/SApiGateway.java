package com.sakura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author chenpingping
 * @version 1.0
 * @date 2021/4/4 20:18
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class SApiGateway {
    public static void main(String[] args) {
        SpringApplication.run(SApiGateway.class, args);
    }

}

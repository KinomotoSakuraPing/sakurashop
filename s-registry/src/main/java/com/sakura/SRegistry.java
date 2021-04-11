package com.sakura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author chenpingping
 * @version 1.0
 * @date 2021/4/4 12:55
 */

@SpringBootApplication
@EnableEurekaServer
public class SRegistry {
    public static void main(String[] args) {
        SpringApplication.run(SRegistry.class, args);

    }
}

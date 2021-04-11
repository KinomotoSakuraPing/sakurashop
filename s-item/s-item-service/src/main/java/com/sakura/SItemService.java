package com.sakura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenpingping
 * @version 1.0
 * @date 2021/4/4 23:45
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SItemService {
    public static void main(String[] args) {
        SpringApplication.run(SItemService.class, args);
    }

}
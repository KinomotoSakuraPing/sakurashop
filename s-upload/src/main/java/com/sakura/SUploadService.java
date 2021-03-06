package com.sakura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenpingping
 * @version 1.0
 * @date 2021/4/15 23:19
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SUploadService {
    public static void main(String[] args) {
        SpringApplication.run(SUploadService.class, args);
    }
}


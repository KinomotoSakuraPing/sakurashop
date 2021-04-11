package com.sakura.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author chenpingping
 * @version 1.0
 * @date 2021/4/7 11:37
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.sakura.item.mapper") // mapper接口的包扫描
public class SakuraItemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SakuraItemServiceApplication.class, args);
    }
}
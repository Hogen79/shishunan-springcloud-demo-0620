package com.shishunan.springcloud.hourseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HouseServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(HouseServiceApp.class,args);
    }
}

package com.sm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SmApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SmApplication.class, args);
        System.out.println(run);

    }


}

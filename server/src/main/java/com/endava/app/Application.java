package com.endava.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by astoica on 8/7/2015.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.endava"})
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}

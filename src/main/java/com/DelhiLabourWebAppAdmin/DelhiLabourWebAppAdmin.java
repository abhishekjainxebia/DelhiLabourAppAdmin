package com.DelhiLabourWebAppAdmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class DelhiLabourWebAppAdmin extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DelhiLabourWebAppAdmin.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DelhiLabourWebAppAdmin.class, args);
    }
}


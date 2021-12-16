package com.example.mail_sender;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class MailSenderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailSenderApplication.class, args);
    }
}
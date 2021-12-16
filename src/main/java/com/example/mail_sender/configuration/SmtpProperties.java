package com.example.mail_sender.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "spring.mail")
public record SmtpProperties(String host, int port, String username, String password) {
}

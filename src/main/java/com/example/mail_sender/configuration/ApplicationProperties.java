package com.example.mail_sender.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "application")
public record ApplicationProperties(int checkEmailsPeriodMillis, short maxAttemptsToSendEmail) {
}

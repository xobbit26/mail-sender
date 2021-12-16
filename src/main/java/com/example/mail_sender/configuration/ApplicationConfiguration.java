package com.example.mail_sender.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Properties;

@Configuration
@EnableScheduling
public class ApplicationConfiguration {
    private final SmtpProperties smtpProperties;

    public ApplicationConfiguration(SmtpProperties smtpProperties) {
        this.smtpProperties = smtpProperties;
    }

    @Bean
    public JavaMailSender getJavaMailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(smtpProperties.host());
        mailSender.setPort(smtpProperties.port());

        mailSender.setUsername(smtpProperties.username());
        mailSender.setPassword(smtpProperties.password());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");


        //only for dev mode
        //todo: create dev and rod profiles
        props.put("mail.debug", "true");

        return mailSender;
    }
}

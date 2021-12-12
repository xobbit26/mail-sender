package com.example.mail_sender.service.impl;

import com.example.mail_sender.service.MailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MailSenderImpl implements MailSender {

    @Override
    @Scheduled(fixedDelay = 1000)
    public void send() {
        System.out.println("hey");
    }
}

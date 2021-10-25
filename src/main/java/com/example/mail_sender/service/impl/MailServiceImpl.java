package com.example.mail_sender.service.impl;

import com.example.mail_sender.dto.MailDto;
import com.example.mail_sender.service.MailService;
import org.springframework.stereotype.Service;


@Service
public class MailServiceImpl implements MailService {

    @Override
    public void create(MailDto mail) {
        System.out.println(mail);
    }
}

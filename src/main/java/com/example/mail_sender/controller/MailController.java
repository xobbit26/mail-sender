package com.example.mail_sender.controller;

import com.example.mail_sender.dto.MailDto;
import com.example.mail_sender.service.MailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("mail")
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }


    @PostMapping
    public void create(@RequestBody MailDto mail) {
        mailService.create(mail);
    }
}

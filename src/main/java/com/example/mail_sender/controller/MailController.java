package com.example.mail_sender.controller;

import com.example.mail_sender.dto.MailDto;
import com.example.mail_sender.service.MailService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("mail")
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }


    @PostMapping("create")
    public void create(@RequestBody MailDto mail) {
        mailService.create(mail);
    }


    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        mailService.delete(id);
    }
}

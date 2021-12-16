package com.example.mail_sender.service;

import com.example.mail_sender.dto.MailDto;
import com.example.mail_sender.entity.Mail;

import java.util.List;

public interface MailService {
    void create(MailDto mail);

    List<Mail> getNotSentMails();

    void update(Mail mail);
}

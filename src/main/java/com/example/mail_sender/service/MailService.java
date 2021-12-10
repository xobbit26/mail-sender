package com.example.mail_sender.service;

import com.example.mail_sender.dto.MailDto;

public interface MailService {
    void create(MailDto mail);

    void delete(Long id);
}

package com.example.mail_sender.service.impl;

import com.example.mail_sender.configuration.ApplicationProperties;
import com.example.mail_sender.dto.MailDto;
import com.example.mail_sender.entity.Mail;
import com.example.mail_sender.repository.MailRepository;
import com.example.mail_sender.service.MailService;
import com.example.mail_sender.util.Constants;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MailServiceImpl implements MailService {
    private final MailRepository mailRepository;
    private final ApplicationProperties applicationProperties;

    public MailServiceImpl(MailRepository mailRepository, ApplicationProperties applicationProperties) {
        this.mailRepository = mailRepository;
        this.applicationProperties = applicationProperties;
    }

    @Override
    public void create(MailDto mailDto) {
        Mail newMail = new Mail(
                mailDto.subject(),
                mailDto.text(),
                mailDto.sender(),
                mailDto.recipient(),
                LocalDateTime.now(),
                Constants.MailStatuses.CREATED
        );
        mailRepository.save(newMail);
    }

    @Override
    public List<Mail> getNotSentMails() {
        List<String> statusesToFilter = List.of(Constants.MailStatuses.CREATED, Constants.MailStatuses.SEND_FAILED);
        return mailRepository.findAllByStatusInAndSendAttemptsLessThan(statusesToFilter, applicationProperties.maxAttemptsToSendEmail());
    }

    @Override
    public void update(Mail mail) {
        mailRepository.save(mail);
    }
}

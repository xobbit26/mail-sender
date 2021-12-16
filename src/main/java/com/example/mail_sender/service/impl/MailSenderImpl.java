package com.example.mail_sender.service.impl;

import com.example.mail_sender.entity.Mail;
import com.example.mail_sender.service.MailSender;
import com.example.mail_sender.service.MailService;
import com.example.mail_sender.util.Constants;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class MailSenderImpl implements MailSender {
    private final JavaMailSender emailSender;
    private final MailService mailService;

    public MailSenderImpl(JavaMailSender emailSender, MailService mailService) {
        this.emailSender = emailSender;
        this.mailService = mailService;
    }

    @Override
    @Scheduled(fixedDelayString = "${application.check-emails-period-millis}")
    public void send() {
        List<Mail> mails = mailService.getNotSentMails();

        mails.forEach(mail -> {
            try {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom(mail.getSender());
                message.setTo(mail.getRecipient());
                message.setSubject(mail.getSubject());
                message.setText(mail.getText());

                emailSender.send(message);
                mail.setStatus(Constants.MailStatuses.SENT_SUCCESS);
            } catch (MailException e) {
                mail.setStatus(Constants.MailStatuses.SEND_FAILED);
                mail.setErrorText(e.getMessage());
            } finally {
                mail.setSendAttempts((short) (mail.getSendAttempts() + 1));
                mail.setSendDateTime(LocalDateTime.now());

                mailService.update(mail);
            }
        });
    }
}

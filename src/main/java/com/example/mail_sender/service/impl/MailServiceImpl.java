package com.example.mail_sender.service.impl;

import com.example.mail_sender.dto.MailDto;
import com.example.mail_sender.entity.Mail;
import com.example.mail_sender.repository.MailRepository;
import com.example.mail_sender.service.MailService;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    private final MailRepository mailRepository;

    public MailServiceImpl(MailRepository mailRepository) {
        this.mailRepository = mailRepository;
    }

    @Override
    public void create(MailDto mailDto) {
        mailRepository.save(mapMailDtoToEntity(mailDto));
    }

    @Override
    public void delete(Long id) {
        mailRepository.deleteById(id);
    }

    private Mail mapMailDtoToEntity(MailDto mailDto) {
        return new Mail(
                mailDto.id(),
                mailDto.title(),
                mailDto.text(),
                mailDto.sender(),
                mailDto.recipient()
        );
    }
}

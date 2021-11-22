package com.example.mail_sender.service.impl;

import com.example.mail_sender.dto.MailDto;
import com.example.mail_sender.entity.Mail;
import com.example.mail_sender.repository.MailRepository;
import com.example.mail_sender.service.MailService;
import com.example.mail_sender.service.QueryService;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    private final MailRepository mailRepository;
    private final QueryService queryService;

    public MailServiceImpl(MailRepository mailRepository, QueryService queryService) {
        this.mailRepository = mailRepository;
        this.queryService = queryService;
    }

    @Override
    public void create(MailDto mailDto) {
//        Mail mailEntity = new Mail(
//                null,
//                mailDto.getTitle(),
//                mailDto.getText(),
//                mailDto.getSender(),
//                mailDto.getRecipient()
//        );
//        mailRepository.save(mailEntity);
        String query = "INSERT INTO mail (title, text, sender, recipient)" +
                " VALUES (?,?,?,?);";
        long id = queryService.executeParametrizedUpdate(query,
                        mailDto.getTitle(),
                        mailDto.getText(),
                        mailDto.getSender(),
                        mailDto.getRecipient())
                .iterator().next();

        System.out.println(id);
    }
}

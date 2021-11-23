package com.example.mail_sender.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MailDto {
    private Integer id;
    private String title;
    private String text;
    private String sender;
    private String recipient;
}

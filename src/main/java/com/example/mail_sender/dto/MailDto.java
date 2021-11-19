package com.example.mail_sender.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MailDto {
    String title;
    String text;
    String sender;
    String recipient;
}

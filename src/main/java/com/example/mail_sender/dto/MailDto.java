package com.example.mail_sender.dto;

public record MailDto(
        String subject,
        String text,
        String sender,
        String recipient) {
}

package com.example.mail_sender.dto;

public record MailDto(
        Long id,
        String title,
        String text,
        String sender,
        String recipient) {
}

package com.example.mail_sender.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mail")
public class Mail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "text")
    private String text;

    @Column(name = "sender")
    private String sender;

    @Column(name = "recipient")
    private String recipient;

    @Column(name = "created_date_time")
    private LocalDateTime createdDateTime;

    @Column(name = "status")
    private String status;

    @Column(name = "send_date_time")
    private LocalDateTime sendDateTime;

    @Column(name = "send_attempts")
    private short sendAttempts;

    @Column(name = "error_text")
    private String errorText;

    public Mail() {
    }

    public Mail(String subject, String text, String sender, String recipient, LocalDateTime createdDateTime, String status) {
        this.subject = subject;
        this.text = text;
        this.sender = sender;
        this.recipient = recipient;
        this.createdDateTime = createdDateTime;
        this.status = status;
    }

    public Mail(Long id,
                String subject,
                String text,
                String sender,
                String recipient,
                LocalDateTime createdDateTime,
                String status,
                LocalDateTime sendDateTime,
                short sendAttempts,
                String errorText) {
        this.id = id;
        this.subject = subject;
        this.text = text;
        this.sender = sender;
        this.recipient = recipient;
        this.createdDateTime = createdDateTime;
        this.status = status;
        this.sendDateTime = sendDateTime;
        this.sendAttempts = sendAttempts;
        this.errorText = errorText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String from) {
        this.sender = from;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String to) {
        this.recipient = to;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getSendDateTime() {
        return sendDateTime;
    }

    public void setSendDateTime(LocalDateTime sendDateTime) {
        this.sendDateTime = sendDateTime;
    }

    public short getSendAttempts() {
        return sendAttempts;
    }

    public void setSendAttempts(short sendAttempts) {
        this.sendAttempts = sendAttempts;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }
}

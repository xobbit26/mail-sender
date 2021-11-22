package com.example.mail_sender.entity;

import javax.persistence.*;

@Entity
@Table(name = "mail")
public class Mail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "sender")
    private String sender;

    @Column(name = "recipient")
    private String recipient;

    public Mail() {
    }

    public Mail(Long id, String title, String text, String sender, String recipient) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.sender = sender;
        this.recipient = recipient;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }
}

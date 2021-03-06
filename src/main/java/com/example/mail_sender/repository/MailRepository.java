package com.example.mail_sender.repository;

import com.example.mail_sender.entity.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailRepository extends JpaRepository<Mail, Long> {
    List<Mail> findAllByStatusInAndSendAttemptsLessThan(List<String> statuses, short attemptsCount);
}

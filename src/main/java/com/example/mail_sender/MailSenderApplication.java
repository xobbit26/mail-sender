package com.example.mail_sender;

import com.example.mail_sender.enums.TestEnum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class MailSenderApplication {

    public static void main(String[] args) {
        System.out.println(TestEnum.VALUE_ONE.getValue());
        System.out.println(TestEnum.VALUE_TWO.getValue());

        SpringApplication.run(MailSenderApplication.class, args);
    }

}

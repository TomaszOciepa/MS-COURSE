package com.tom.notifications.service;

import com.tom.notifications.dto.EmailDto;
import jakarta.mail.MessagingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailSenderTest {

    @Autowired
    EmailSender emailSender;

    @Test
    public void send_email_test() throws MessagingException {
        EmailDto emailDto = EmailDto.builder()
                .to("tomek0290@gmail.com")
                .title("hejo!!!")
                .content("test wiadomości. Real Mistrz!!!")
                .build();
        emailSender.sendEmail(emailDto);
    }
}

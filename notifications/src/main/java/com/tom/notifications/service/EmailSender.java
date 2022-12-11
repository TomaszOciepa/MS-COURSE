package com.tom.notifications.service;

import com.tom.notifications.dto.EmailDto;
import com.tom.notifications.dto.NotificationinfoDto;
import jakarta.mail.MessagingException;

public interface EmailSender {

    void sendEmails(NotificationinfoDto notificationinfo);
//    void sendEmail(String to, String title, String content) throws MessagingException;
    void sendEmail(EmailDto emailDto) throws MessagingException;
}

package com.tom.notifications.service;

import com.tom.notifications.dto.NotificationinfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMqListener {

//    Logger logger = LoggerFactory.getLogger(RabbitMqListener.class);

    private final EmailSender emailSender;

    public RabbitMqListener(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @RabbitListener(queues = "enroll_finish")
    public void handleFinishEnroll(NotificationinfoDto notificationinfo){
        emailSender.sendEmails(notificationinfo);
    }
}

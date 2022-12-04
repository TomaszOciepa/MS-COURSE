package com.tom.notifications.service;

import com.tom.notifications.dto.NotificationinfoDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMqListener {

//    Logger logger = LoggerFactory.getLogger(RabbitMqListener.class);

    @RabbitListener(queues = "enroll_finish")
    public void handleFinishEnroll(NotificationinfoDto notificationinfo){
        log.info(notificationinfo.toString());
    }
}

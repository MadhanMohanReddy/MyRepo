package org.mine.components;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by madhan.reddy on 4/26/2017.
 */

@Component
public class Scheduler {
  private static final Logger log = LoggerFactory.getLogger(Scheduler.class);

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  @Autowired
  private JavaMailSender mailSender;

  //@Scheduled(fixedRate = 5000)
  @Scheduled(cron = "*/10 * * * * *")
  public void reportCurrentTime() {
    log.info("The time is now {}", dateFormat.format(new Date()));
    //this.send();

  }

  public void send() {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("madhan.mr37@gmail.com");
    message.setTo("madhan.mr37@gmail.com");
    message.setSubject("hello");
    mailSender.send(message);
  }
}


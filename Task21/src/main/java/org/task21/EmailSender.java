package org.task21;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.task21.entity.Game;

@Service
@AllArgsConstructor
public class EmailSender
{
    private final JavaMailSender javaMailSender;

    @Async
    public void sendEmail(Game game) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("isakov.29072004@gmail.com");
        message.setTo("isakov.29072004@gmail.com");
        message.setSubject("Info message");
        message.setText(game.toString());

        javaMailSender.send(message);
    }
}
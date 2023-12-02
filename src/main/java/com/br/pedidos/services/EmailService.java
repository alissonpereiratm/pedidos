package com.br.pedidos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.br.pedidos.entities.Pedido;


@Service
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(Pedido pedido) {

      
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("naianegoulartoliveira@gmail.com");
            message.setTo("alissonpereiratm@gmail.com");
            message.setSubject("PEDIDO");
            message.setText(pedido.toString());
            emailSender.send(message);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

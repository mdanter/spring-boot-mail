package com.example.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;



@Component
public class MailConfig {
	@Autowired
	JavaMailSenderImpl sender = new JavaMailSenderImpl();

	public void sendmail(String to, String subject, String body) throws MessagingException {

		sender.setHost("mailcatcher.mdanter.svc");
		sender.setPort(25);

		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(to);

		helper.setSubject(subject);

		helper.setText(body);

		sender.send(message);

	}

}

package com.example.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailTriggerController {

	@Autowired
	public MailConfig emailSender;

	@RequestMapping("/mail")
	@ResponseBody
	String send() throws MessagingException {
		emailSender.sendmail("mdanter@gmail.com", "This is Testing", "Thank you for reading this email");
		return "The email have been sent";
	}

}

package com.arjuncodes.springemaildemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringEmailDemoApplication {

	@Autowired
	private EmailSenderService senderService;
	public static void main(String[] args) {
		SpringApplication.run(SpringEmailDemoApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		senderService.sendSimpleEmail("antoniohenriquep@outlook.com",
				"Email automático mandado por rotina",
				"A partir de hoje você receberá um email diário lhe lembrando do quão fuleiro é");

	}
}

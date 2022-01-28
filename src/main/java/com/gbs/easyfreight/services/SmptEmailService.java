package com.gbs.easyfreight.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SmptEmailService extends AbstractEmailService{

	private static final Logger LOG = LoggerFactory.getLogger(SmptEmailService.class);
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender javaSender;
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de Email....");		
		mailSender.send(msg);	
		LOG.info("Email enviado!");		
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Enviando Email....");		
		javaSender.send(msg);	
		LOG.info("Email enviado!");	
		
	}

}

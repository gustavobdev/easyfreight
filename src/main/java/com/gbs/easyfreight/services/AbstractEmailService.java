package com.gbs.easyfreight.services;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.gbs.easyfreight.domain.Motorista;

public abstract class AbstractEmailService implements EmailService{

	
	@Value("${default.sender}")
	private String sender;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendNewDataDriver(Motorista obj) {	
		SimpleMailMessage sm = prepareSimpleMailMessageFromMotorista(obj);
		sendEmail(sm);
	}

	private SimpleMailMessage prepareSimpleMailMessageFromMotorista(Motorista obj) {

		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getEmail());
		sm.setFrom(sender);		
		sm.setSubject("Bem-vindo " + obj.getNome());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}

	
	protected String HtmlNewMotorista(Motorista obj) {
		Context context = new Context();
		context.setVariable("motorista", obj);
		return templateEngine.process("email/confirmacaoCadastroMotorista", context);
	}
	
	@Override
	public void sendConfirmationHtmlEmail(Motorista obj) {
		try {
			MimeMessage mm = prepareMimeMessageMessageFromMotorista(obj);
			sendHtmlEmail(mm);
		}catch(MessagingException e) {
			sendConfirmationHtmlEmail(obj);
		}
	}

	protected MimeMessage prepareMimeMessageMessageFromMotorista(Motorista obj) throws MessagingException {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
		mmh.setTo(obj.getEmail());
		mmh.setFrom(sender);
		mmh.setSubject("Bem vindo filho da puta!" + obj.getNome());
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(HtmlNewMotorista(obj), true);
		return mimeMessage;
	}

}

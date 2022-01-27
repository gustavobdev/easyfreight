package com.gbs.easyfreight.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.gbs.easyfreight.domain.Motorista;

public abstract class AbstractEmailService implements EmailService{

	
	@Value("${default.sender}")
	private String sender;
	
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


}

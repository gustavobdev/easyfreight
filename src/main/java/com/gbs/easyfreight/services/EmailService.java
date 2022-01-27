package com.gbs.easyfreight.services;

import org.springframework.mail.SimpleMailMessage;

import com.gbs.easyfreight.domain.Motorista;

public interface EmailService {

	void sendNewDataDriver(Motorista obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	
}

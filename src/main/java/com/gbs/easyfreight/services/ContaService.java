package com.gbs.easyfreight.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbs.easyfreight.domain.Conta;
import com.gbs.easyfreight.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repo;
	
	public Conta find(Integer id) {
		Optional<Conta> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}

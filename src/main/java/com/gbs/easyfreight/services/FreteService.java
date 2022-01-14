package com.gbs.easyfreight.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbs.easyfreight.domain.Frete;
import com.gbs.easyfreight.repositories.FreteRepository;

@Service
public class FreteService {

	@Autowired
	private FreteRepository repo;
	
	public Frete find(Integer id) {
		Optional<Frete> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}

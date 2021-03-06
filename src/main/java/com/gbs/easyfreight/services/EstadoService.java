package com.gbs.easyfreight.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbs.easyfreight.domain.Estado;
import com.gbs.easyfreight.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repo;
	
	public Estado find(Integer id) {
		Optional<Estado> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}

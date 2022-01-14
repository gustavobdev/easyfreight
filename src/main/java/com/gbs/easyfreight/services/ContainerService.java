package com.gbs.easyfreight.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbs.easyfreight.domain.Container;
import com.gbs.easyfreight.repositories.ContainerRepository;

@Service
public class ContainerService {

	@Autowired
	private ContainerRepository repo;
	
	public Container find(Integer id) {
		Optional<Container> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}

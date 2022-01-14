package com.gbs.easyfreight.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gbs.easyfreight.domain.Motorista;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Integer>{
	
	@Transactional(readOnly=true)
	Motorista findByEmail(String email);
	
}

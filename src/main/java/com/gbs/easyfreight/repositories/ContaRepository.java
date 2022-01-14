package com.gbs.easyfreight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gbs.easyfreight.domain.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{
	
}

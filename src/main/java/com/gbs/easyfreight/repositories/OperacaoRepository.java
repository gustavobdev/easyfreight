package com.gbs.easyfreight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gbs.easyfreight.domain.Operacao;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Integer>{
	
}

package com.gbs.easyfreight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gbs.easyfreight.domain.Caminhao;

@Repository
public interface CaminhaoRepository extends JpaRepository<Caminhao, Integer>{
	
}

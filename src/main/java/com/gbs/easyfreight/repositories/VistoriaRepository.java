package com.gbs.easyfreight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gbs.easyfreight.domain.Vistoria;

@Repository
public interface VistoriaRepository extends JpaRepository<Vistoria, Integer>{
	
}

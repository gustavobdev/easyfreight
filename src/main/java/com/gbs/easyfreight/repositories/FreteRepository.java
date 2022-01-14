package com.gbs.easyfreight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gbs.easyfreight.domain.Frete;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Integer>{
	
}

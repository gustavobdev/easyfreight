package com.gbs.easyfreight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gbs.easyfreight.domain.Rota;

@Repository
public interface RotaRepository extends JpaRepository<Rota, Integer>{
	
}

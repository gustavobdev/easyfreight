package com.gbs.easyfreight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gbs.easyfreight.domain.Container;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Integer>{
	
}

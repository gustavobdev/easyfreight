package com.gbs.easyfreight.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gbs.easyfreight.domain.Frete;
import com.gbs.easyfreight.services.FreteService;

@RestController
@RequestMapping(value="/fretes")
public class FreteResource {

	
	@Autowired
	private FreteService service;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Frete obj = service.find(id);
		return ResponseEntity.ok().body(obj);		
	}
	
}

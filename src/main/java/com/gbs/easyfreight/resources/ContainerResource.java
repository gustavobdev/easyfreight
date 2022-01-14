package com.gbs.easyfreight.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gbs.easyfreight.domain.Container;
import com.gbs.easyfreight.services.ContainerService;

@RestController
@RequestMapping(value="/containers")
public class ContainerResource {

	
	@Autowired
	private ContainerService service;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Container obj = service.find(id);
		return ResponseEntity.ok().body(obj);		
	}
	
}

package com.gbs.easyfreight.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gbs.easyfreight.domain.Motorista;
import com.gbs.easyfreight.domain.dto.MotoristaDTO;
import com.gbs.easyfreight.domain.dto.MotoristaNewDTO;
import com.gbs.easyfreight.services.MotoristaService;

@RestController
@RequestMapping(value="/motoristas")
public class MotoristaResource {

	
	@Autowired
	private MotoristaService service;
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Motorista obj = service.find(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody MotoristaNewDTO objDto){
		Motorista obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}" , method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody MotoristaDTO objDTO, @PathVariable Integer id) {
		Motorista obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MotoristaDTO>> findAll() {
		List<Motorista> list = service.findAll();
		List<MotoristaDTO> listDto = list.stream().map(obj -> new MotoristaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);		
	}
	
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<MotoristaDTO>> findPage(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC") String direction) {
		Page<Motorista> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<MotoristaDTO> listDto = list.map(obj -> new MotoristaDTO(obj));
		return ResponseEntity.ok().body(listDto);		
	}
}

package com.gbs.easyfreight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gbs.easyfreight.domain.Cidade;
import com.gbs.easyfreight.domain.Cliente;
import com.gbs.easyfreight.domain.Endereco;
import com.gbs.easyfreight.domain.dto.ClienteDTO;
import com.gbs.easyfreight.domain.dto.ClienteNewDTO;
import com.gbs.easyfreight.repositories.ClienteRepository;
import com.gbs.easyfreight.repositories.EnderecoRepository;
import com.gbs.easyfreight.services.exceptions.DataIntegrityException;
import com.gbs.easyfreight.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())); 
	}
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);	
		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}
	
	public Cliente update(Cliente obj) {	
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir Cliente com contas atreladas");
		}
	}
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage, Direction.valueOf(direction),orderBy);	
		return repo.findAll(pageRequest);
		}
	
	public Cliente fromDTO(ClienteDTO objDTO) {
		return new Cliente(objDTO.getId(), objDTO.getRazao(), objDTO.getCnpj(), objDTO.getEmail());	
	}
	
	public Cliente fromDTO(ClienteNewDTO objDTO) {
		Cliente cli = new Cliente(null,objDTO.getRazao(), objDTO.getCnpj(), objDTO.getEmail());	
		Cidade cidade = new Cidade(objDTO.getCidadeId(),null,null);
		Endereco end = new Endereco(null, objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getComplemento(), objDTO.getBairro(),objDTO.getCep(),cidade, cli, null);
		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDTO.getTelefone1());
		if(objDTO.getTelefone2()!= null) {
			cli.getTelefones().add(objDTO.getTelefone2());
		}
		if(objDTO.getTelefone3()!=null) {
			cli.getTelefones().add(objDTO.getTelefone3());
		}
		return cli;
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setRazao(obj.getRazao());
		newObj.setCnpj(obj.getCnpj());
		newObj.setEmail(obj.getEmail());
	}
	
}

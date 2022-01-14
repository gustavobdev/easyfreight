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
import com.gbs.easyfreight.domain.Motorista;
import com.gbs.easyfreight.domain.dto.MotoristaDTO;
import com.gbs.easyfreight.domain.dto.MotoristaNewDTO;
import com.gbs.easyfreight.repositories.EnderecoRepository;
import com.gbs.easyfreight.repositories.MotoristaRepository;
import com.gbs.easyfreight.services.exceptions.DataIntegrityException;
import com.gbs.easyfreight.services.exceptions.ObjectNotFoundException;

@Service
public class MotoristaService {

	@Autowired
	private MotoristaRepository repo;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Motorista find(Integer id) {
		Optional<Motorista> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Motorista.class.getName())); 
	}
	
	@Transactional
	public Motorista insert(Motorista obj) {
		obj.setId(null);	
		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}
	
	public Motorista update(Motorista obj) {	
		Motorista newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir Motorista com contas atreladas");
		}
	}
	
	public List<Motorista> findAll(){
		return repo.findAll();
	}
	
	public Page<Motorista> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage, Direction.valueOf(direction),orderBy);	
		return repo.findAll(pageRequest);
		}
	
	public Motorista fromDTO(MotoristaDTO objDTO) {
		return new Motorista(objDTO.getId(), objDTO.getNome(), objDTO.getSobrenome(), null,null, objDTO.getEmail(), objDTO.getSenha(), null, null);	
	}
	
	public Motorista fromDTO(MotoristaNewDTO objDTO) {
		Motorista motor = new Motorista(null, objDTO.getNome(), objDTO.getSobrenome(), objDTO.getCpf(), 
				objDTO.getNascimento(), objDTO.getEmail(), objDTO.getSenha(), objDTO.getCnh(), objDTO.getValidade());	
		Cidade cidade = new Cidade(objDTO.getCidadeId(),null,null);
		Endereco end = new Endereco(null, objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getComplemento(), objDTO.getBairro(),objDTO.getCep(),cidade, null, motor);
		motor.getEnderecos().add(end);
		motor.getTelefones().add(objDTO.getTelefone1());
		if(objDTO.getTelefone2()!= null) {
			motor.getTelefones().add(objDTO.getTelefone2());
		}
		if(objDTO.getTelefone3()!=null) {
			motor.getTelefones().add(objDTO.getTelefone3());
		}
		return motor;
	}
	
	private void updateData(Motorista newObj, Motorista obj) {
		newObj.setNome(obj.getNome());
		newObj.setSobrenome(obj.getSobrenome());
		newObj.setEmail(obj.getEmail());
		newObj.setSenha(obj.getSenha());
	}
	
}

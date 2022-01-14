package com.gbs.easyfreight.domain.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gbs.easyfreight.domain.Motorista;

public class MotoristaDTO  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=5,max=80,message="O Tamanho deve ser entre 5 e 10 caracteres")
	private String nome;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=5,max=80,message="O Tamanho deve ser entre 5 e 10 caracteres")
	private String sobrenome;
	private String cpf;
	
	@JsonFormat(pattern = "dd/MM/yyy")
	private Date nascimento;
	
	@NotEmpty(message="Preenchimento do email é Obrigatório")
	@Email(message="Email inválido")
	private String email;
	private String senha;
	private Integer cnh;
	
	@JsonFormat(pattern = "dd/MM/yyy")
	private Date validade;
	
	
	
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public MotoristaDTO(Motorista obj) {
		id = obj.getId();
		nome = obj.getNome();
		sobrenome = obj.getSobrenome();
		cpf = obj.getCpf();
		nascimento = obj.getNascimento();
		email = obj.getEmail();
		senha = obj.getSenha();
		cnh = obj.getCnh();
		validade = obj.getValidade();				
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getCnh() {
		return cnh;
	}

	public void setCnh(Integer cnh) {
		this.cnh = cnh;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public MotoristaDTO() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

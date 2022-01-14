package com.gbs.easyfreight.domain.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;


public class MotoristaNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento Obrigatório")
	@Length(min=5,max=120, message="O tamamnho deve ser entre 5 e 120 caracteres" )
	private String nome;
	private String sobrenome;
	@CPF
	private String cpf;
	@JsonFormat(pattern = "dd/MM/yyy")
	private Date nascimento;
	
	@NotEmpty(message = "Preenchimento Obrigatório")
	@Email(message="Email inválido" )
	private String email;
	private String senha;
	private Integer cnh;
	@JsonFormat(pattern = "dd/MM/yyy")
	private Date validade;
	
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String cep;
	
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String telefone1;
	private String telefone2;
	private String telefone3;
	
	private Integer cidadeId;
	
	public MotoristaNewDTO(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}
}

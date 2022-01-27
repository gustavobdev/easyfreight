package com.gbs.easyfreight.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Motorista implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sobrenome;
	private String cpf;
	
	@JsonFormat(pattern = "dd/MM/yyy")
	private Date nascimento;
	
	private String email;
	private String senha;
	private Integer cnh;
	
	@JsonFormat(pattern = "dd/MM/yyy")
	private Date validade;
	
	@JsonIgnore
	@OneToOne(mappedBy = "motorista")
	private Conta contas;
	
	@JsonIgnore
	@OneToMany(mappedBy = "motorista")	
	private List<Frete> fretes = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="TELEFONES")
	private Set<String> telefones = new HashSet<>();  
	
	@ManyToMany
	@JoinTable(
			name = "CAMINHAO_MOTORISTA",
			joinColumns = @JoinColumn(name="motorista_id"),
			inverseJoinColumns = @JoinColumn(name="caminhao_id")
		)
	private List<Caminhao> caminhoes = new ArrayList<>();

	@ManyToMany
	@JoinTable(
			name = "REBOQUE_MOTORISTA",
			joinColumns = @JoinColumn(name="motorista_id"),
			inverseJoinColumns = @JoinColumn(name="reboque_id")
		)
	private List<Reboque> reboques = new ArrayList<>();
	
	@OneToMany(mappedBy = "motorista",cascade=CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();
	
	public Motorista() {
		
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Conta getContas() {
		return contas;
	}

	public void setContas(Conta contas) {
		this.contas = contas;
	}

	public List<Frete> getFretes() {
		return fretes;
	}

	public void setFretes(List<Frete> fretes) {
		this.fretes = fretes;
	}

	public List<Caminhao> getCaminhoes() {
		return caminhoes;
	}

	public void setCaminhoes(List<Caminhao> caminhoes) {
		this.caminhoes = caminhoes;
	}

	public List<Reboque> getReboques() {
		return reboques;
	}

	public void setReboques(List<Reboque> reboques) {
		this.reboques = reboques;
	}

	public Motorista(Integer id, String nome, String sobrenome, String cpf, Date nascimento, String email, String senha,
			Integer cnh, Date validade) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.email = email;
		this.senha = senha;
		this.cnh = cnh;
		this.validade = validade;
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
	
	public Conta getConta() {
		return contas;
	}

	public void setConta(Conta conta) {
		this.contas = conta;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motorista other = (Motorista) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Motorista [nome=");
		builder.append(nome);
		builder.append(", sobrenome=");
		builder.append(sobrenome);
		builder.append(", email=");
		builder.append(email);
		builder.append(", senha=");
		builder.append(senha);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}

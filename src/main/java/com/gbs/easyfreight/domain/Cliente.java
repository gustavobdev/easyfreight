package com.gbs.easyfreight.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente  implements Serializable {

	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	private String razao;
	private String cnpj;
	private String email;
	
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos = new ArrayList<>();
	
	@OneToMany(mappedBy = "cliente")
	private List<Frete> fretes = new ArrayList<>();
	
	public Cliente() {
		
	}

	public Cliente(Integer id, String razao, String cnpj, String email) {
		super();
		this.id = id;
		this.razao = razao;
		this.cnpj = cnpj;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
	
}

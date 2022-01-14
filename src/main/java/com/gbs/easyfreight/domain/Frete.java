package com.gbs.easyfreight.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Frete implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ref;
	private String conteudo;
	private Double peso_total;
	
	@JsonIgnore
	@OneToMany(mappedBy = "frete")
	private List<Container> containers = new ArrayList<>();
		
	@ElementCollection
	@CollectionTable(name="NCM")
	private Set<String> ncms = new HashSet<>();  
	
	@OneToOne(mappedBy = "frete")
	private Operacao operacao;
	
	@ManyToOne
	@JoinColumn(name="motorista_id")
	private Motorista motorista;
	
	@OneToOne(mappedBy = "frete")
	private Rota rota;
	
	@ManyToOne
	@JoinColumn(name = "consignatario_id")
	private Cliente cliente;
	
	public Frete(){
		
	}

	public Frete(Integer id, String ref, String conteudo, Double peso_total, List<Container> containers,
			Operacao operacao, Motorista motorista, Rota rota,Cliente cliente ) {
		super();
		this.id = id;
		this.ref = ref;
		this.conteudo = conteudo;
		this.peso_total = peso_total;
		this.containers = containers;
		this.operacao = operacao;
		this.motorista = motorista;
		this.rota = rota;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Double getPeso_total() {
		return peso_total;
	}

	public void setPeso_total(Double peso_total) {
		this.peso_total = peso_total;
	}

	public List<Container> getContainers() {
		return containers;
	}

	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}

	public Set<String> getNcms() {
		return ncms;
	}

	public void setNcms(Set<String> ncms) {
		this.ncms = ncms;
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}	

	


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Frete other = (Frete) obj;
		return Objects.equals(id, other.id);
	}
}

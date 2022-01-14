package com.gbs.easyfreight.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vistoria implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyy")
	private Date created_at;
	private Integer status;

	@ElementCollection
	@CollectionTable(name="OBS")
	private Set<String> observacoes = new HashSet<>();  
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "caminhao_id")
	private Caminhao caminhao;
	
	public Vistoria(){		
	}
	
	public Vistoria(Integer id, Date created_at, Integer status, Caminhao caminhao) {
		super();
		this.id = id;
		this.created_at = created_at;
		this.status = status;
		this.caminhao = caminhao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set<String> getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(Set<String> observacoes) {
		this.observacoes = observacoes;
	}

	public Caminhao getCaminhao() {
		return caminhao;
	}

	public void setCaminhao(Caminhao caminhao) {
		this.caminhao = caminhao;
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
		Vistoria other = (Vistoria) obj;
		return Objects.equals(id, other.id);
	}	
	
	
}

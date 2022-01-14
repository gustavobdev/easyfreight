package com.gbs.easyfreight.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Rota implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="origem")
	private Cidade origem;
	
	private String origem_completa;
	
	@ManyToOne
	@JoinColumn(name="coleta")
	private Cidade coleta;
	
	private String coleta_completa;
	
	@ManyToOne
	@JoinColumn(name="entrega")
	private Cidade entrega;
	
	private String entrega_completa;
	
	@ManyToOne
	@JoinColumn(name="devolucao")
	private Cidade devolucao;
	
	private String devolucao_completa;
	
	@JsonIgnore
	@OneToOne()
	@JoinColumn(name="frete_id")
	private Frete frete;

	public Rota() {
		
	}
	
	public Rota(Integer id, Cidade origem, String origem_completa, Cidade coleta, String coleta_completa,
			Cidade entrega, String entrega_completa, Cidade devolucao, String devolucao_completa, Frete frete) {
		super();
		this.id = id;
		this.origem = origem;
		this.origem_completa = origem_completa;
		this.coleta = coleta;
		this.coleta_completa = coleta_completa;
		this.entrega = entrega;
		this.entrega_completa = entrega_completa;
		this.devolucao = devolucao;
		this.devolucao_completa = devolucao_completa;
		this.frete = frete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cidade getOrigem() {
		return origem;
	}

	public void setOrigem(Cidade origem) {
		this.origem = origem;
	}

	public String getOrigem_completa() {
		return origem_completa;
	}

	public void setOrigem_completa(String origem_completa) {
		this.origem_completa = origem_completa;
	}

	public Cidade getColeta() {
		return coleta;
	}

	public void setColeta(Cidade coleta) {
		this.coleta = coleta;
	}

	public String getColeta_completa() {
		return coleta_completa;
	}

	public void setColeta_completa(String coleta_completa) {
		this.coleta_completa = coleta_completa;
	}

	public Cidade getEntrega() {
		return entrega;
	}

	public void setEntrega(Cidade entrega) {
		this.entrega = entrega;
	}

	public String getEntrega_completa() {
		return entrega_completa;
	}

	public void setEntrega_completa(String entrega_completa) {
		this.entrega_completa = entrega_completa;
	}

	public Cidade getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Cidade devolucao) {
		this.devolucao = devolucao;
	}

	public String getDevolucao_completa() {
		return devolucao_completa;
	}

	public void setDevolucao_completa(String devolucao_completa) {
		this.devolucao_completa = devolucao_completa;
	}

	public Frete getFrete() {
		return frete;
	}

	public void setFrete(Frete frete) {
		this.frete = frete;
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
		Rota other = (Rota) obj;
		return Objects.equals(id, other.id);
	}
	
	
		
}

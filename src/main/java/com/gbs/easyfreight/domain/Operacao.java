package com.gbs.easyfreight.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Operacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyy HH:mm")
	private Date retirada;
	
	@JsonFormat(pattern = "dd/MM/yyy HH:mm")
	private Date prevRetirada;
	
	@JsonFormat(pattern = "dd/MM/yyy HH:mm")
	private Date coleta;
	
	@JsonFormat(pattern = "dd/MM/yyy HH:mm")
	private Date prevColeta;
	
	@JsonFormat(pattern = "dd/MM/yyy HH:mm")
	private Date chegada;
	
	@JsonFormat(pattern = "dd/MM/yyy HH:mm")
	private Date prevChegada;
	
	@JsonFormat(pattern = "dd/MM/yyy HH:mm")
	private Date devolucao;
	
	@JsonFormat(pattern = "dd/MM/yyy HH:mm")	
	private Date prevDevolucao;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="frete_id")
	private Frete frete;
	
	public Operacao() {
		
	}

	public Operacao(Integer id, Date retirada, Date prevRetirada, Date coleta, Date prevColeta, Date chegada,
			Date prevChegada, Date devolucao, Date prevDevolucao, Frete frete) {
		super();
		this.id = id;
		this.retirada = retirada;
		this.prevRetirada = prevRetirada;
		this.coleta = coleta;
		this.prevColeta = prevColeta;
		this.chegada = chegada;
		this.prevChegada = prevChegada;
		this.devolucao = devolucao;
		this.prevDevolucao = prevDevolucao;
		this.frete = frete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getRetirada() {
		return retirada;
	}

	public void setRetirada(Date retirada) {
		this.retirada = retirada;
	}

	public Date getPrevRetirada() {
		return prevRetirada;
	}

	public void setPrevRetirada(Date prevRetirada) {
		this.prevRetirada = prevRetirada;
	}

	public Date getColeta() {
		return coleta;
	}

	public void setColeta(Date coleta) {
		this.coleta = coleta;
	}

	public Date getPrevColeta() {
		return prevColeta;
	}

	public void setPrevColeta(Date prevColeta) {
		this.prevColeta = prevColeta;
	}

	public Date getChegada() {
		return chegada;
	}

	public void setChegada(Date chegada) {
		this.chegada = chegada;
	}

	public Date getPrevChegada() {
		return prevChegada;
	}

	public void setPrevChegada(Date prevChegada) {
		this.prevChegada = prevChegada;
	}

	public Date getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Date devolucao) {
		this.devolucao = devolucao;
	}

	public Date getPrevDevolucao() {
		return prevDevolucao;
	}

	public void setPrevDevolucao(Date prevDevolucao) {
		this.prevDevolucao = prevDevolucao;
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
		Operacao other = (Operacao) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}

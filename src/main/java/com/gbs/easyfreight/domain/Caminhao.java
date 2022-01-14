package com.gbs.easyfreight.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Caminhao implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String renavam;
	private String placa;
	private String cor;
	private String modelo;
	private Integer ano;
	private String tipo;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "caminhoes")
	private List<Motorista> motoristas = new ArrayList<>();
	
	@OneToMany(mappedBy = "caminhao")
	private List<Vistoria> vistorias = new ArrayList<>();
	
	public Caminhao(){
		
	}

	public Caminhao(Integer id, String renavam, String placa, String cor, String modelo, Integer ano, String tipo) {
		super();
		this.id = id;
		this.renavam = renavam;
		this.placa = placa;
		this.cor = cor;
		this.modelo = modelo;
		this.ano = ano;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Motorista> getMotoristas() {
		return motoristas;
	}

	public void setMotoristas(List<Motorista> motoristas) {
		this.motoristas = motoristas;
	}

	public List<Vistoria> getVistorias() {
		return vistorias;
	}

	public void setVistorias(List<Vistoria> vistorias) {
		this.vistorias = vistorias;
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
		Caminhao other = (Caminhao) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}

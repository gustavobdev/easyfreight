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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reboque implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String renavam;
	private String placa;
	private String tipoReboque;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "reboques")
	private List<Motorista> motoristas = new ArrayList<>();
	
	public Reboque() {
		
	}

	public Reboque(Integer id, String renavam, String placa, String tipoReboque) {
		super();
		this.id = id;
		this.renavam = renavam;
		this.placa = placa;
		this.tipoReboque = tipoReboque;
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

	public String getTipoReboque() {
		return tipoReboque;
	}

	public void setTipoReboque(String tipoReboque) {
		this.tipoReboque = tipoReboque;
	}

	public List<Motorista> getMotoristas() {
		return motoristas;
	}

	public void setMotoristas(List<Motorista> motoristas) {
		this.motoristas = motoristas;
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
		Reboque other = (Reboque) obj;
		return Objects.equals(id, other.id);
	}	
}

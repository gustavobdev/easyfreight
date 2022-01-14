package com.gbs.easyfreight.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Container implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String numero;
	private Integer size;
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="frete_id")
	private Frete frete;
	
	public Container() {
		
	}

	public Container(Integer id, String numero, Integer size, String tipo, Frete frete) {
		super();
		this.id = id;
		this.numero = numero;
		this.size = size;
		this.tipo = tipo;
		this.frete = frete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		Container other = (Container) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}

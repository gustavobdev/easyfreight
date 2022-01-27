package com.gbs.easyfreight.domain.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CNPJ;

import com.gbs.easyfreight.domain.Cliente;

public class ClienteDTO implements Serializable {

		private static final long serialVersionUID = 1L;	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)	
		private Integer id;
		
		@NotEmpty(message="Preenchimento do Razão é Obrigatório")
		private String razao;
		
		@NotEmpty(message="Preenchimento do CNPJ é Obrigatório")
		@CNPJ(message="Cnpj Inválido")
		private String cnpj;
		
		@NotEmpty(message="Preenchimento do email é Obrigatório")
		@Email(message="Email inválido")
		private String email;
		
		public ClienteDTO(){
			
		}
		
		public ClienteDTO(Cliente obj) {
			id = obj.getId();
			razao = obj.getRazao();
			cnpj = obj.getCnpj();
			email = obj.getEmail();					
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
		
}

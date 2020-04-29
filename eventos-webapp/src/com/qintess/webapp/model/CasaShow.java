package com.qintess.webapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter  @Setter
@Table(name="casashow")
public class CasaShow {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private int id;
	
	@Column (name = "nome", nullable = true)
	private String nome;
	
	@Column (name = "logradouro", nullable = true)
	private String logradouro;
	
	@Column (name = "numero", nullable = true)
	private int numero;
	
	@Column (name = "complemento", nullable = true)
	private String complemento;
	
	@Column (name = "cep", nullable = true)
	private int cep;
	
	@Column (name = "cidade", nullable = true)
	private String cidade;
	
	@Column (name = "estado", nullable = true)
	private String estado;
	
	@Column (name = "capacidade", nullable = true)
	private String capacidade;
	
	@Column (name = "valor", nullable = true)
	private double valor;

	
}

package com.qintess.webapp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "Compra_Ingresso")
public class CompraIngresso {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@MapsId("id_Compra")
	private Compra compra;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@MapsId("id_Ingresso")
	private Ingresso ingresso;
	
	@Column(name ="quantidade")
	private double quantidade;
	
	@Column(name ="valor")
	private double valor;
	
	public CompraIngresso(Compra compra2, Ingresso ingresso2, double qtd) {};
	
	public CompraIngresso(Compra compra, Ingresso ingresso, double quantidade, double valor) {
		this.compra = compra;
		this.ingresso = ingresso;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Ingresso getIngresso() {
		return ingresso;
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double qtdingressocompra) {
		this.quantidade = qtdingressocompra;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}

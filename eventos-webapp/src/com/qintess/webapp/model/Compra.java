package com.qintess.webapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter  @Setter
@Table(name = "Compra")
public class Compra {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (nullable = false)
	private double valor;
	
	@Column (nullable = false)
	private LocalDate dtCompra;
	
	@Column (nullable = false)
	private String status;
	
	@Column (nullable = true)
	private String observacao;
	
	@ManyToOne
	@JoinColumn (name = "id_cliente", nullable = false)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<CompraIngresso> ingressos = new ArrayList<CompraIngresso>();
	
	//Método que irá adicionar um novo ingresso a compra
	public void adicionarIngresso (Ingresso ingresso, double qtd) {
		CompraIngresso compraIngresso = new CompraIngresso (this, ingresso, qtd);

		//relacionamento bilateral
		ingressos.add(compraIngresso);
		Ingresso.getCompras().add(compraIngresso);
		
		//atualizando valor da compra de acordo com o total de ingressos e suas quantidades
		double valorCompra = this.valor;
		double valorIngressoUnit = Ingresso.getValorunit();
		
		valorCompra += (valorIngressoUnit * qtd);
		
		this.valor = new Double (valorCompra);   
	}
	
	
	
}


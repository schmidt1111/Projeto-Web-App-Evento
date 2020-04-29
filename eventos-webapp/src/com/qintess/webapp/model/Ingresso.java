package com.qintess.webapp.model;

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


@Entity
@Table(name = "Ingresso")
public class Ingresso {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id", nullable = false)
	private int id;
	
	@Column (name = "valor_unit", nullable = false)
	private static double valorunit;
	
	@ManyToOne
	@JoinColumn (name = "id_evento", nullable=false)
	private Evento evento;
	
	@OneToMany (mappedBy="compra_ingresso", cascade = CascadeType.ALL, orphanRemoval = true)
	private static List<CompraIngresso> compras = new ArrayList<CompraIngresso>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static double getValorunit() {
		return valorunit;
	}

	public void setValorunit(double valorunit) {
		Ingresso.valorunit = valorunit;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public static List<CompraIngresso> getCompras() {
		return compras;
	}

	public void setCompras(List<CompraIngresso> compras) {
		Ingresso.compras = compras;
	}

}

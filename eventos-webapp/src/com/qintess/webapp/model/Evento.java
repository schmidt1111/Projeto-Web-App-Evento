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
@Getter @Setter
@Table(name = "Evento")
public class Evento {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_evento")
	private int id;
	
	@Column (name = "nome", nullable = false)
	private String nome;
	
	@Column (name = "descricao", nullable = false)
	private String descricao;
	
	@Column (name = "dt_evento", nullable = false)
	private LocalDate dtevento;
	
	@Column (name="faixa_etaria", nullable = false)
	private int faixaetaria;
	
	@Column (name="folder", nullable = false)
	private byte folder;
	
	@Column (name="qtd_ingresso_disponivel", nullable = false)
	private int qtdingressodisponivel;
	
	@ManyToOne
	@JoinColumn (name = "id_casadeshow", nullable=false)
	private CasaShow casashow;
	
	@OneToMany(mappedBy = "ingresso", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<CompraIngresso> ingressos = new ArrayList<CompraIngresso>();

	public int getId() {
		return id;
	}
}

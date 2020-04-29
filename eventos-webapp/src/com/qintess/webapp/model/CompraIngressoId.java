package com.qintess.webapp.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompraIngressoId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int compraId;
	
	private int ingressoId;
	
	public CompraIngressoId(int compraId, int ingressoId) {
		this.compraId = compraId;
		this.ingressoId = ingressoId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + compraId;
		result = prime * result + ingressoId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompraIngressoId other = (CompraIngressoId) obj;
		if (compraId != other.compraId)
			return false;
		if (ingressoId != other.ingressoId)
			return false;
		return true;
	}
	
	//è necessario fazer a implementação dos metodos equals e hashcode
	

}

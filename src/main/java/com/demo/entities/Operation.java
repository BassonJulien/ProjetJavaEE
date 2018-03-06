package com.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Operation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@javax.persistence.Id@GeneratedValue
	private long Id;
	private Date dateOperation;
	private double montant;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	private String type;
	@ManyToOne
	@JoinColumn(name="codeCompte")
	private Compte compte;
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operation(Date dateOperation, double montant, String type, Compte compte) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.type = type;
		this.compte = compte;
	}

}

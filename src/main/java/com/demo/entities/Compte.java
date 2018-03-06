package com.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compte implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue
	private long IdCompte;
	private Date dateCreation;
	private double solde;
	@ManyToOne
	@JoinColumn(name="codeClient")
	private Client Client;
	
	@OneToMany(mappedBy="compte")
	private Collection<Operation> operations;

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIdCompte() {
		return IdCompte;
	}

	public void setIdCompte(long idCompte) {
		IdCompte = idCompte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client client) {
		Client = client;
	}

	public Collection<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

	public Compte(Date dateCreation, double solde, com.demo.entities.Client client) {
		super();
		this.dateCreation = dateCreation;
		this.solde = solde;
		Client = client;
	}
}

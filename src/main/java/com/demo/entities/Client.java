package com.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue
	private long idClient;
	private String nom;
	private String email;
	@OneToMany(mappedBy="Client")
	private Collection<Compte> comptes;
	
	public long getIdClient() {
		return idClient;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	public Client(String nom, String email) {
		super();
		this.nom = nom;
		this.email = email;
	}

}

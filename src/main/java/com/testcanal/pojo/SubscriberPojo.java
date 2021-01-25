package com.testcanal.pojo;

public class SubscriberPojo {

	
	private String nom;
	private String prenom;
	private String adressePrincipale;
	private String pays;
	public SubscriberPojo(String nom, String prenom, String adressePrincipale, String pays) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adressePrincipale = adressePrincipale;
		this.pays = pays;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdressePrincipale() {
		return adressePrincipale;
	}
	public void setAdressePrincipale(String adressePrincipale) {
		this.adressePrincipale = adressePrincipale;
	}
	
}

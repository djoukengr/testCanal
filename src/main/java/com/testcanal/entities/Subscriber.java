/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testcanal.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DJOUKENG
 */
@Entity
@Table(name = "subscriber")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subscriber.findAll", query = "SELECT s FROM Subscriber s")
    , @NamedQuery(name = "Subscriber.findByIdSubscriber", query = "SELECT s FROM Subscriber s WHERE s.idSubscriber = :idSubscriber")
    , @NamedQuery(name = "Subscriber.findByNom", query = "SELECT s FROM Subscriber s WHERE s.nom = :nom")
    , @NamedQuery(name = "Subscriber.findByPrenom", query = "SELECT s FROM Subscriber s WHERE s.prenom = :prenom")
    , @NamedQuery(name = "Subscriber.findByAdressePrincipale", query = "SELECT s FROM Subscriber s WHERE s.adressePrincipale = :adressePrincipale")
    , @NamedQuery(name = "Subscriber.findByPays", query = "SELECT s FROM Subscriber s WHERE s.pays = :pays")})
public class Subscriber implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idSubscriber")
    private String idSubscriber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "adressePrincipale")
    private String adressePrincipale;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pays")
    private String pays;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subscriberidSubscriber")
    private List<Contract> contractList;

    public Subscriber() {
    }

    public Subscriber(String idSubscriber) {
        this.idSubscriber = idSubscriber;
    }

    public Subscriber(String idSubscriber, String nom, String prenom, String adressePrincipale, String pays) {
        this.idSubscriber = idSubscriber;
        this.nom = nom;
        this.prenom = prenom;
        this.adressePrincipale = adressePrincipale;
        this.pays = pays;
    }

    public String getIdSubscriber() {
        return idSubscriber;
    }

    public void setIdSubscriber(String idSubscriber) {
        this.idSubscriber = idSubscriber;
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

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @XmlTransient
    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubscriber != null ? idSubscriber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subscriber)) {
            return false;
        }
        Subscriber other = (Subscriber) object;
        if ((this.idSubscriber == null && other.idSubscriber != null) || (this.idSubscriber != null && !this.idSubscriber.equals(other.idSubscriber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.testcanal.entities.Subscriber[ idSubscriber=" + idSubscriber + " ]";
    }
    
}

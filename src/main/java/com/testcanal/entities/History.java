/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testcanal.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DJOUKENG
 */
@Entity
@Table(name = "history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "History.findAll", query = "SELECT h FROM History h")
    , @NamedQuery(name = "History.findByIdMouvement", query = "SELECT h FROM History h WHERE h.idMouvement = :idMouvement")
    , @NamedQuery(name = "History.findByIdSubscriber", query = "SELECT h FROM History h WHERE h.idSubscriber = :idSubscriber")
    , @NamedQuery(name = "History.findByIdContract", query = "SELECT h FROM History h WHERE h.idContract = :idContract")
    , @NamedQuery(name = "History.findByTypeModification", query = "SELECT h FROM History h WHERE h.typeModification = :typeModification")
    , @NamedQuery(name = "History.findByDateModification", query = "SELECT h FROM History h WHERE h.dateModification = :dateModification")
    , @NamedQuery(name = "History.findByOldValue", query = "SELECT h FROM History h WHERE h.oldValue = :oldValue")
    , @NamedQuery(name = "History.findByNewValue", query = "SELECT h FROM History h WHERE h.newValue = :newValue")})
public class History implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idMouvement")
    private String idMouvement;
    @Size(max = 45)
    @Column(name = "idSubscriber")
    private String idSubscriber;
    @Size(max = 45)
    @Column(name = "idContract")
    private String idContract;
    @Size(max = 45)
    @Column(name = "typeModification")
    private String typeModification;
    @Size(max = 45)
    @Column(name = "dateModification")
    private String dateModification;
    @Size(max = 45)
    @Column(name = "oldValue")
    private String oldValue;
    @Size(max = 45)
    @Column(name = "newValue")
    private String newValue;

    public History() {
    }

    public History(String idMouvement) {
        this.idMouvement = idMouvement;
    }

    public String getIdMouvement() {
        return idMouvement;
    }

    public void setIdMouvement(String idMouvement) {
        this.idMouvement = idMouvement;
    }

    public String getIdSubscriber() {
        return idSubscriber;
    }

    public void setIdSubscriber(String idSubscriber) {
        this.idSubscriber = idSubscriber;
    }

    public String getIdContract() {
        return idContract;
    }

    public void setIdContract(String idContract) {
        this.idContract = idContract;
    }

    public String getTypeModification() {
        return typeModification;
    }

    public void setTypeModification(String typeModification) {
        this.typeModification = typeModification;
    }

    public String getDateModification() {
        return dateModification;
    }

    public void setDateModification(String dateModification) {
        this.dateModification = dateModification;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMouvement != null ? idMouvement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof History)) {
            return false;
        }
        History other = (History) object;
        if ((this.idMouvement == null && other.idMouvement != null) || (this.idMouvement != null && !this.idMouvement.equals(other.idMouvement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.testcanal.entities.History[ idMouvement=" + idMouvement + " ]";
    }
    
}

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "contract")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contract.findAll", query = "SELECT c FROM Contract c")
    , @NamedQuery(name = "Contract.findByIdContract", query = "SELECT c FROM Contract c WHERE c.idContract = :idContract")
    , @NamedQuery(name = "Contract.findByAddress", query = "SELECT c FROM Contract c WHERE c.address = :address")})
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idContract")
    private String idContract;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "address")
    private String address;
    @Column(name = "Subscriber_idSubscriber")
    private String subscriberidSubscriber;

    public Contract() {
    }

    public Contract(String idContract) {
        this.idContract = idContract;
    }

    public Contract(String idContract, String address) {
        this.idContract = idContract;
        this.address = address;
    }

    public String getIdContract() {
        return idContract;
    }

    public void setIdContract(String idContract) {
        this.idContract = idContract;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubscriberidSubscriber() {
        return subscriberidSubscriber;
    }

    public void setSubscriberidSubscriber(String subscriberidSubscriber) {
        this.subscriberidSubscriber = subscriberidSubscriber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContract != null ? idContract.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contract)) {
            return false;
        }
        Contract other = (Contract) object;
        if ((this.idContract == null && other.idContract != null) || (this.idContract != null && !this.idContract.equals(other.idContract))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.testcanal.entities.Contract[ idContract=" + idContract + " ]";
    }
    
}

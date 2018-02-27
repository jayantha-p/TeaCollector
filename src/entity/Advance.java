/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jayantha
 */
@Entity
@Table(name = "advance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advance.findAll", query = "SELECT a FROM Advance a")
    , @NamedQuery(name = "Advance.findByAdvId", query = "SELECT a FROM Advance a WHERE a.advId = :advId")
    , @NamedQuery(name = "Advance.findByAmount", query = "SELECT a FROM Advance a WHERE a.amount = :amount")
    , @NamedQuery(name = "Advance.findByPaid", query = "SELECT a FROM Advance a WHERE a.paid = :paid")
    , @NamedQuery(name = "Advance.findByStatus", query = "SELECT a FROM Advance a WHERE a.status = :status")
    , @NamedQuery(name = "Advance.findByStartMonth", query = "SELECT a FROM Advance a WHERE a.startMonth = :startMonth")
    , @NamedQuery(name = "Advance.findByTimeMonth", query = "SELECT a FROM Advance a WHERE a.timeMonth = :timeMonth")})
public class Advance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "adv_id")
    private Integer advId;
    @Basic(optional = false)
    @Column(name = "amount")
    private int amount;
    @Basic(optional = false)
    @Column(name = "paid")
    private int paid;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @Column(name = "startMonth")
    @Temporal(TemporalType.DATE)
    private Date startMonth;
    @Basic(optional = false)
    @Column(name = "time_month")
    private int timeMonth;
    @JoinColumn(name = "supplierID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Supplier supplierID;

    public Advance() {
    }

    public Advance(Integer advId) {
        this.advId = advId;
    }

    public Advance(Integer advId, int amount, int paid, boolean status, Date startMonth, int timeMonth) {
        this.advId = advId;
        this.amount = amount;
        this.paid = paid;
        this.status = status;
        this.startMonth = startMonth;
        this.timeMonth = timeMonth;
    }

    public Integer getAdvId() {
        return advId;
    }

    public void setAdvId(Integer advId) {
        this.advId = advId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Date startMonth) {
        this.startMonth = startMonth;
    }

    public int getTimeMonth() {
        return timeMonth;
    }

    public void setTimeMonth(int timeMonth) {
        this.timeMonth = timeMonth;
    }

    public Supplier getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Supplier supplierID) {
        this.supplierID = supplierID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (advId != null ? advId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advance)) {
            return false;
        }
        Advance other = (Advance) object;
        if ((this.advId == null && other.advId != null) || (this.advId != null && !this.advId.equals(other.advId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Advance[ advId=" + advId + " ]";
    }
    
}

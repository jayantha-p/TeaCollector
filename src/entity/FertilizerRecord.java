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
@Table(name = "fertilizer_record")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FertilizerRecord.findAll", query = "SELECT f FROM FertilizerRecord f")
    , @NamedQuery(name = "FertilizerRecord.findById", query = "SELECT f FROM FertilizerRecord f WHERE f.id = :id")
    , @NamedQuery(name = "FertilizerRecord.findByAmount", query = "SELECT f FROM FertilizerRecord f WHERE f.amount = :amount")
    , @NamedQuery(name = "FertilizerRecord.findByNoOfMonth", query = "SELECT f FROM FertilizerRecord f WHERE f.noOfMonth = :noOfMonth")
    , @NamedQuery(name = "FertilizerRecord.findByDate", query = "SELECT f FROM FertilizerRecord f WHERE f.date = :date")})
public class FertilizerRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "amount")
    private int amount;
    @Basic(optional = false)
    @Column(name = "NoOfMonth")
    private int noOfMonth;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Supplier supplierId;

    public FertilizerRecord() {
    }

    public FertilizerRecord(Integer id) {
        this.id = id;
    }

    public FertilizerRecord(Integer id, int amount, int noOfMonth, Date date) {
        this.id = id;
        this.amount = amount;
        this.noOfMonth = noOfMonth;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getNoOfMonth() {
        return noOfMonth;
    }

    public void setNoOfMonth(int noOfMonth) {
        this.noOfMonth = noOfMonth;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FertilizerRecord)) {
            return false;
        }
        FertilizerRecord other = (FertilizerRecord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FertilizerRecord[ id=" + id + " ]";
    }
    
}

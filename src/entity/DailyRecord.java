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
@Table(name = "daily_record")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DailyRecord.findAll", query = "SELECT d FROM DailyRecord d")
    , @NamedQuery(name = "DailyRecord.findByRecordID", query = "SELECT d FROM DailyRecord d WHERE d.recordID = :recordID")
    , @NamedQuery(name = "DailyRecord.findByDate", query = "SELECT d FROM DailyRecord d WHERE d.date = :date")
    , @NamedQuery(name = "DailyRecord.findByTotalAmount", query = "SELECT d FROM DailyRecord d WHERE d.totalAmount = :totalAmount")
    , @NamedQuery(name = "DailyRecord.findByCutAmount", query = "SELECT d FROM DailyRecord d WHERE d.cutAmount = :cutAmount")
    , @NamedQuery(name = "DailyRecord.findByFinalAmount", query = "SELECT d FROM DailyRecord d WHERE d.finalAmount = :finalAmount")})
public class DailyRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "recordID")
    private Integer recordID;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "total_amount")
    private Integer totalAmount;
    @Column(name = "cut_amount")
    private Integer cutAmount;
    @Basic(optional = false)
    @Column(name = "final_amount")
    private int finalAmount;
    @JoinColumn(name = "supplierID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Supplier supplierID;

    public DailyRecord() {
    }

    public DailyRecord(Integer recordID) {
        this.recordID = recordID;
    }

    public DailyRecord(Integer recordID, Date date, int finalAmount) {
        this.recordID = recordID;
        this.date = date;
        this.finalAmount = finalAmount;
    }

    public Integer getRecordID() {
        return recordID;
    }

    public void setRecordID(Integer recordID) {
        this.recordID = recordID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getCutAmount() {
        return cutAmount;
    }

    public void setCutAmount(Integer cutAmount) {
        this.cutAmount = cutAmount;
    }

    public int getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(int finalAmount) {
        this.finalAmount = finalAmount;
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
        hash += (recordID != null ? recordID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DailyRecord)) {
            return false;
        }
        DailyRecord other = (DailyRecord) object;
        if ((this.recordID == null && other.recordID != null) || (this.recordID != null && !this.recordID.equals(other.recordID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DailyRecord[ recordID=" + recordID + " ]";
    }
    
}

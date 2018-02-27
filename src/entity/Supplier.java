/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jayantha
 */
@Entity
@Table(name = "supplier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supplier.findAll", query = "SELECT s FROM Supplier s")
    , @NamedQuery(name = "Supplier.findById", query = "SELECT s FROM Supplier s WHERE s.id = :id")
    , @NamedQuery(name = "Supplier.findBySupplierID", query = "SELECT s FROM Supplier s WHERE s.supplierID = :supplierID")
    , @NamedQuery(name = "Supplier.findByName", query = "SELECT s FROM Supplier s WHERE s.name = :name")
    , @NamedQuery(name = "Supplier.findByTelephone", query = "SELECT s FROM Supplier s WHERE s.telephone = :telephone")})
public class Supplier implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierId")
    private Collection<FertilizerRecord> fertilizerRecordCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierId")
    private Collection<TeaPacket> teaPacketCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierId")
    private Collection<FertilizerRecord> fertilizerCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "supplier_ID")
    private int supplierID;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierID")
    private Collection<DailyRecord> dailyRecordCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierID")
    private Collection<Advance> advanceCollection;

    public Supplier() {
    }

    public Supplier(Integer id) {
        this.id = id;
    }

    public Supplier(Integer id, int supplierID, String name) {
        this.id = id;
        this.supplierID = supplierID;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @XmlTransient
    public Collection<DailyRecord> getDailyRecordCollection() {
        return dailyRecordCollection;
    }

    public void setDailyRecordCollection(Collection<DailyRecord> dailyRecordCollection) {
        this.dailyRecordCollection = dailyRecordCollection;
    }

    @XmlTransient
    public Collection<Advance> getAdvanceCollection() {
        return advanceCollection;
    }

    public void setAdvanceCollection(Collection<Advance> advanceCollection) {
        this.advanceCollection = advanceCollection;
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
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Supplier[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<FertilizerRecord> getFertilizerCollection() {
        return fertilizerCollection;
    }

    public void setFertilizerCollection(Collection<FertilizerRecord> fertilizerCollection) {
        this.fertilizerCollection = fertilizerCollection;
    }

    @XmlTransient
    public Collection<TeaPacket> getTeaPacketCollection() {
        return teaPacketCollection;
    }

    public void setTeaPacketCollection(Collection<TeaPacket> teaPacketCollection) {
        this.teaPacketCollection = teaPacketCollection;
    }

    @XmlTransient
    public Collection<FertilizerRecord> getFertilizerRecordCollection() {
        return fertilizerRecordCollection;
    }

    public void setFertilizerRecordCollection(Collection<FertilizerRecord> fertilizerRecordCollection) {
        this.fertilizerRecordCollection = fertilizerRecordCollection;
    }
    
}

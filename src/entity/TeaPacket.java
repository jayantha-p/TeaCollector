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
@Table(name = "tea_packet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeaPacket.findAll", query = "SELECT t FROM TeaPacket t")
    , @NamedQuery(name = "TeaPacket.findById", query = "SELECT t FROM TeaPacket t WHERE t.id = :id")
    , @NamedQuery(name = "TeaPacket.findByQuantity", query = "SELECT t FROM TeaPacket t WHERE t.quantity = :quantity")
    , @NamedQuery(name = "TeaPacket.findByDate", query = "SELECT t FROM TeaPacket t WHERE t.date = :date")})
public class TeaPacket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Supplier supplierId;

    public TeaPacket() {
    }

    public TeaPacket(Integer id) {
        this.id = id;
    }

    public TeaPacket(Integer id, int quantity, Date date) {
        this.id = id;
        this.quantity = quantity;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        if (!(object instanceof TeaPacket)) {
            return false;
        }
        TeaPacket other = (TeaPacket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TeaPacket[ id=" + id + " ]";
    }
    
}

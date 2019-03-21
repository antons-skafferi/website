/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tobias
 */
@Entity
@Table(name = "dinnertable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dinnertable.findAll", query = "SELECT d FROM Dinnertable d")
    , @NamedQuery(name = "Dinnertable.findByTableId", query = "SELECT d FROM Dinnertable d WHERE d.tableId = :tableId")
    , @NamedQuery(name = "Dinnertable.findBySeat", query = "SELECT d FROM Dinnertable d WHERE d.seat = :seat")})
public class Dinnertable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "table_id")
    private Integer tableId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seat")
    private short seat;

    public Dinnertable() {
    }

    public Dinnertable(Integer tableId) {
        this.tableId = tableId;
    }

    public Dinnertable(Integer tableId, short seat) {
        this.tableId = tableId;
        this.seat = seat;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public short getSeat() {
        return seat;
    }

    public void setSeat(short seat) {
        this.seat = seat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tableId != null ? tableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dinnertable)) {
            return false;
        }
        Dinnertable other = (Dinnertable) object;
        if ((this.tableId == null && other.tableId != null) || (this.tableId != null && !this.tableId.equals(other.tableId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Dinnertable[ tableId=" + tableId + " ]";
    }

}

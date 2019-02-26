/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tobias
 */
@Entity
@javax.persistence.Table(name = "table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Table.findAll", query = "SELECT t FROM Table t")
    , @NamedQuery(name = "Table.findByTableId", query = "SELECT t FROM Table t WHERE t.tablePK.tableId = :tableId")
    , @NamedQuery(name = "Table.findBySeat", query = "SELECT t FROM Table t WHERE t.tablePK.seat = :seat")})
public class Table implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TablePK tablePK;

    public Table() {
    }

    public Table(TablePK tablePK) {
        this.tablePK = tablePK;
    }

    public Table(int tableId, short seat) {
        this.tablePK = new TablePK(tableId, seat);
    }

    public TablePK getTablePK() {
        return tablePK;
    }

    public void setTablePK(TablePK tablePK) {
        this.tablePK = tablePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tablePK != null ? tablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Table)) {
            return false;
        }
        Table other = (Table) object;
        if ((this.tablePK == null && other.tablePK != null) || (this.tablePK != null && !this.tablePK.equals(other.tablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Table[ tablePK=" + tablePK + " ]";
    }
    
}

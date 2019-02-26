/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Tobias
 */
@Embeddable
public class TablePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "table_id")
    private int tableId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seat")
    private short seat;

    public TablePK() {
    }

    public TablePK(int tableId, short seat) {
        this.tableId = tableId;
        this.seat = seat;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
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
        hash += (int) tableId;
        hash += (int) seat;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TablePK)) {
            return false;
        }
        TablePK other = (TablePK) object;
        if (this.tableId != other.tableId) {
            return false;
        }
        if (this.seat != other.seat) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TablePK[ tableId=" + tableId + ", seat=" + seat + " ]";
    }
    
}

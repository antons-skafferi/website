/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Tobias
 */
@Embeddable
public class SchedulePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "staff_id")
    private String staffId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_hour")
    @Temporal(TemporalType.TIME)
    private Date startHour;

    public SchedulePK() {
    }

    public SchedulePK(Date date, String staffId, Date startHour) {
        this.date = date;
        this.staffId = staffId;
        this.startHour = startHour;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public Date getStartHour() {
        return startHour;
    }

    public void setStartHour(Date startHour) {
        this.startHour = startHour;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (date != null ? date.hashCode() : 0);
        hash += (staffId != null ? staffId.hashCode() : 0);
        hash += (startHour != null ? startHour.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchedulePK)) {
            return false;
        }
        SchedulePK other = (SchedulePK) object;
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        if ((this.staffId == null && other.staffId != null) || (this.staffId != null && !this.staffId.equals(other.staffId))) {
            return false;
        }
        if ((this.startHour == null && other.startHour != null) || (this.startHour != null && !this.startHour.equals(other.startHour))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SchedulePK[ date=" + date + ", staffId=" + staffId + ", startHour=" + startHour + " ]";
    }
    
}

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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tobias
 */
@Entity
@Table(name = "lunch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lunch.findAll", query = "SELECT l FROM Lunch l")
    , @NamedQuery(name = "Lunch.findByLunchId", query = "SELECT l FROM Lunch l WHERE l.lunchId = :lunchId")
    , @NamedQuery(name = "Lunch.findByFoodId", query = "SELECT l FROM Lunch l WHERE l.foodId = :foodId")
    , @NamedQuery(name = "Lunch.findByDate", query = "SELECT l FROM Lunch l WHERE l.date = :date")
    , @NamedQuery(name = "Lunch.findByPrice", query = "SELECT l FROM Lunch l WHERE l.price = :price")
    , @NamedQuery(name = "Lunch.findAllFood", query = "SELECT f FROM Food f INNER JOIN Lunch l ON f.food_id = l.food_id")})

public class Lunch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lunch_id")
    private String lunchId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "food_id")
    private int foodId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;

    public Lunch() {
    }

    public Lunch(String lunchId) {
        this.lunchId = lunchId;
    }

    public Lunch(String lunchId, int foodId, Date date, int price) {
        this.lunchId = lunchId;
        this.foodId = foodId;
        this.date = date;
        this.price = price;
    }

    public String getLunchId() {
        return lunchId;
    }

    public void setLunchId(String lunchId) {
        this.lunchId = lunchId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lunchId != null ? lunchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lunch)) {
            return false;
        }
        Lunch other = (Lunch) object;
        if ((this.lunchId == null && other.lunchId != null) || (this.lunchId != null && !this.lunchId.equals(other.lunchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "api.Lunch[ lunchId=" + lunchId + " ]";
    }

}

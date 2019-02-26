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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tobias
 */
@Entity
@Table(name = "dinner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dinner.findAll", query = "SELECT d FROM Dinner d")
    , @NamedQuery(name = "Dinner.findByDinnerId", query = "SELECT d FROM Dinner d WHERE d.dinnerId = :dinnerId")
    , @NamedQuery(name = "Dinner.findByFoodId", query = "SELECT d FROM Dinner d WHERE d.foodId = :foodId")
    , @NamedQuery(name = "Dinner.findByPrice", query = "SELECT d FROM Dinner d WHERE d.price = :price")})
public class Dinner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dinner_id")
    private String dinnerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "food_id")
    private int foodId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;

    public Dinner() {
    }

    public Dinner(String dinnerId) {
        this.dinnerId = dinnerId;
    }

    public Dinner(String dinnerId, int foodId, int price) {
        this.dinnerId = dinnerId;
        this.foodId = foodId;
        this.price = price;
    }

    public String getDinnerId() {
        return dinnerId;
    }

    public void setDinnerId(String dinnerId) {
        this.dinnerId = dinnerId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
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
        hash += (dinnerId != null ? dinnerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dinner)) {
            return false;
        }
        Dinner other = (Dinner) object;
        if ((this.dinnerId == null && other.dinnerId != null) || (this.dinnerId != null && !this.dinnerId.equals(other.dinnerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "api.Dinner[ dinnerId=" + dinnerId + " ]";
    }
    
}

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
@Table(name = "drink")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drink.findAll", query = "SELECT d FROM Drink d")
    , @NamedQuery(name = "Drink.findByDrinkId", query = "SELECT d FROM Drink d WHERE d.drinkId = :drinkId")
    , @NamedQuery(name = "Drink.findByDrinkName", query = "SELECT d FROM Drink d WHERE d.drinkName = :drinkName")
    , @NamedQuery(name = "Drink.findByPrice", query = "SELECT d FROM Drink d WHERE d.price = :price")})
public class Drink implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "drink_id")
    private String drinkId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "drink_name")
    private String drinkName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;

    public Drink() {
    }

    public Drink(String drinkId) {
        this.drinkId = drinkId;
    }

    public Drink(String drinkId, String drinkName, int price) {
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.price = price;
    }

    public String getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(String drinkId) {
        this.drinkId = drinkId;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
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
        hash += (drinkId != null ? drinkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Drink)) {
            return false;
        }
        Drink other = (Drink) object;
        if ((this.drinkId == null && other.drinkId != null) || (this.drinkId != null && !this.drinkId.equals(other.drinkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "api.Drink[ drinkId=" + drinkId + " ]";
    }
    
}

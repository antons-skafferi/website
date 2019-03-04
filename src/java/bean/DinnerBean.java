/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import facade.DinnerFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author JohnE
 */
@Named(value = "dinnerbean")
@SessionScoped
public class DinnerBean implements Serializable {
    private int dinnerID;
    private int foodID;
    private int price;
    
    
    @EJB
    private DinnerFacade dinnerFacade;

    public int getDinnerID() {
        return dinnerID;
    }

    public void setDinnerID(int dinnerID) {
        this.dinnerID = dinnerID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
}

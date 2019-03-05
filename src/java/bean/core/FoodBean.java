/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.core;

import entities.Food;
import facade.FoodFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author JohnE
 */
@Named(value = "foodbean")
@SessionScoped
public class FoodBean implements Serializable {

    @EJB
    private FoodFacade foodFacade;

    public List<Food> foodList() {
        return foodFacade.findAll();
    }
}

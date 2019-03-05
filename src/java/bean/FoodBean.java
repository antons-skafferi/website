/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

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

    private String dish;
    private String description;
    private String ingrediens;
    private String category;

    private List<Integer> selectedFoodIDs;

    @EJB
    private FoodFacade foodFacade;

    public List<Integer> getSelectedFoodIDs() {
        return selectedFoodIDs;
    }

    public void setSelectedFoodIDs(List<Integer> selectedFoodIDs) {
        this.selectedFoodIDs = selectedFoodIDs;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngrediens() {
        return ingrediens;
    }

    public void setIngrediens(String ingrediens) {
        this.ingrediens = ingrediens;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Food> foodList() {
        return foodFacade.findAll();
    }

    public void addfoodForm() {

        if (ingrediens == null) {
            foodFacade.create(new Food(null, dish, description, category));
        } else {
            foodFacade.create(new Food(null, dish, description, category, ingrediens));
        }

    }

    public void deleteFood() {
        for (Integer foodID : selectedFoodIDs) {
            foodFacade.deleteFood(foodID);

        }
    }
    

}

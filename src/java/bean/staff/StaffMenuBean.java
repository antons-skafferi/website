/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.staff;

import bean.core.FoodBean;
import entities.Dinner;
import entities.Food;
import entities.Lunch;
import facade.DinnerFacade;
import facade.FoodFacade;
import facade.LunchFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

@Named(value = "staffMenuBean")
@SessionScoped
public class StaffMenuBean implements Serializable {

    private String dish;
    private String description;
    private String ingrediens;
    private String category;
    
    private List<Integer> selectedFoodIDs;
    private List<String> selectedLunchIDs;
    private List<String> selectedDinnerIDs;
    
    @EJB
    private FoodFacade foodFacade;
    @EJB
    private LunchFacade lunchFacade;
    @EJB
    private DinnerFacade dinnerFacade;

    
    @Inject
    private FoodBean foodBean; // +setter (no getter!)
    
    java.util.Date uDate = new java.util.Date();
    java.sql.Date sDate = convertUtilToSql(uDate);   

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
    
    public void setFoodBean(FoodBean foodBean) {
        this.foodBean = foodBean;
    }
    
    public List<Integer> getSelectedFoodIDs() {
        return selectedFoodIDs;
    }

    public void setSelectedFoodIDs(List<Integer> selectedFoodIDs) {
        this.selectedFoodIDs = selectedFoodIDs;
    }
    
    public List<String> getSelectedLunchIDs() {
        return selectedLunchIDs;
    }

    public void setSelectedLunchIDs(List<String> selectedLunchIDs) {
        this.selectedLunchIDs = selectedLunchIDs;
    }
    
    public List<String> getSelectedDinnerIDs() {
        return selectedDinnerIDs;
    }

    public void setSelectedDinnerIDs(List<String> selectedDinnerIDs) {
        this.selectedDinnerIDs = selectedDinnerIDs;
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

    public void addLunch() {
      for (Integer foodID : selectedFoodIDs) {      
            lunchFacade.create(new Lunch("lunch"+foodID.toString(), foodID, sDate, 100) );
       }
    }
    
    public void deleteLunch() {
        for (String lunchID : selectedLunchIDs) {
            lunchFacade.deleteLunch(lunchID);
        }
    }
    
    public void addDinner() {
      for (Integer foodID : selectedFoodIDs) {      
            dinnerFacade.create(new Dinner("dinner"+foodID.toString(), foodID, 100) );
       }
    }
    
    public void deleteDinner() {
        for (String dinnerID : selectedDinnerIDs) {
            dinnerFacade.deleteDinner(dinnerID);
        }
    }
    
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
    
}

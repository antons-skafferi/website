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
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "staffMenuBean")
@SessionScoped
public class StaffMenuBean implements Serializable {

    private String dish;
    private String description;
    private String ingrediens;

    private String category;

    private int dinnerPrice;
    private Date lunchDate;
    private List<Food> selectedFood;
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

    //java.util.Date uDate = new java.util.Date();
    //java.sql.Date sDate = convertUtilToSql(uDate);

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

    public int getDinnerPrice() {
        return dinnerPrice;
    }

    public void setDinnerPrice(int dinnerPrice) {
        this.dinnerPrice = dinnerPrice;
    }

    public Date getLunchDate() {
        return lunchDate;
    }

    public void setLunchDate(Date lunchDate) {
        this.lunchDate = lunchDate;
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

    public List<Food> getSelectedFood() {
        return selectedFood;
    }

    public void setSelectedFood(List<Food> selectedFood) {
        this.selectedFood = selectedFood;
    }

    public void addfoodForm() {

        if (ingrediens == null) {
            foodFacade.create(new Food(null, dish, description, category));
        } else {
            foodFacade.create(new Food(null, dish, description, category, ingrediens));
        }

    }

    public void deleteFood() {
        List<Lunch> allLunch = lunchFacade.findAll();
        List<Dinner> allDinner = dinnerFacade.findAll();

        for (Food food : selectedFood) {

            foodFacade.deleteFood(food.getFoodId());

            for (Lunch lunch : allLunch) {
                if (lunch.getFoodId() == food.getFoodId()) {
                    lunchFacade.remove(lunch);
                }
            }
            for (Dinner dinner : allDinner) {
                if (dinner.getFoodId() == food.getFoodId()) {
                    dinnerFacade.remove(dinner);
                }
            }

        }

    }

    public void addLunch() {

        for (Food food : selectedFood) {
            lunchFacade.create(new Lunch("lunch" + food.getFoodId().toString(), food.getFoodId(), lunchDate, 100));
        }
        /*
        for (Integer foodID : selectedFoodIDs) {
            lunchFacade.create(new Lunch("lunch" + foodID.toString(), foodID, sDate, 100));
        }
         */
    }

    public void deleteLunch() {
        for (String lunchID : selectedLunchIDs) {
            lunchFacade.deleteLunch(lunchID);
        }
    }

    public void addDinner() {

        for (Food food : selectedFood) {
            dinnerFacade.create(new Dinner("dinner" + food.getFoodId().toString(), food.getFoodId(), dinnerPrice));
        }
/*
        for (Integer foodID : selectedFoodIDs) {
            dinnerFacade.create(new Dinner("dinner" + foodID.toString(), foodID, dinnerPrice));
        }
*/
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.core;

import entities.Dinner;
import entities.Food;
import facade.DinnerFacade;
import facade.FoodFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    @EJB
    private FoodFacade foodFacade;

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
    
        
    public List<Food> getAllDinnerAsFood(){
        List<Dinner> dinners = dinnerFacade.findAll();
        List<Food> allFood = foodFacade.findAll();

        List<Food> dinnerFood = new ArrayList<Food>();
        for(Dinner dinner : dinners){
            for(Food food : allFood){
                if(dinner.getFoodId() == food.getFoodId()){
                    dinnerFood.add(food);
                }
            }
        }
        return dinnerFood;
    }
    
    public List<Food> getMainCourse(){
        List<Food> dinners = getAllDinnerAsFood();
        List<Food> mainCourse = new ArrayList<Food>();
        
        for(Food food : dinners){
            if(food.getCategory().equals("main_menu")){
                mainCourse.add(food);
            }
        }  
        return mainCourse;
    }
    
    public List<Food> getChildMenu(){
        List<Food> dinners = getAllDinnerAsFood();
        List<Food> childMenu = new ArrayList<Food>();
        
        for(Food food : dinners){
            if(food.getCategory().equals("child_menu")){
                childMenu.add(food);
            }
        }   
        return childMenu;
    }
    
    public List<Food> getStarter(){
        List<Food> dinners = getAllDinnerAsFood();
        List<Food> starter = new ArrayList<Food>();
        
        for(Food food : dinners){
            if(food.getCategory().equals("appetizer_menu")){
                starter.add(food);
            }
        }  
        return starter;
    }
    
    public List<Food> getDessert(){
        List<Food> dinners = getAllDinnerAsFood();
        List<Food> dessert = new ArrayList<Food>();
        
        for(Food food : dinners){
            if(food.getCategory().equals("dessert_menu")){
                dessert.add(food);
            }
        }
        return dessert;
    }
    
    public Dinner getDinner(Food food){
        List<Dinner> dinners = dinnerFacade.findAll();
        for(Dinner dinner : dinners){
            if(dinner.getFoodId() == food.getFoodId()){
                return dinner;
            }
        }
        return null;
    }
}

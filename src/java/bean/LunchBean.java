/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Food;
import entities.Lunch;
import facade.FoodFacade;
import facade.LunchFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author JohnE
 */
@Named(value = "lunchbean")
@SessionScoped
public class LunchBean implements Serializable {

    private int lunchId;
    private int foodId;
    private Date date;
    private int price;
    
    @EJB
    private LunchFacade lunchFacade;
    @EJB
    private FoodFacade foodFacade;

    public int getLunchId() {
        return lunchId;
    }

    public void setLunchId(int lunchId) {
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
    
    public List<Food> getAllLunchAsFood(){
        //return lunchFacade.findAllFood();
        List<Lunch> lunches = lunchFacade.findAll();
        List<Food> allFood = foodFacade.findAll();

        List<Food> lunchFood = new ArrayList<Food>();
        for(Lunch lunch : lunches){
            for(Food food : allFood){
                if(lunch.getFoodId() == food.getFoodId()){
                    lunchFood.add(food);
                }
            }
        }
        return lunchFood;
    }
    
    public List<Food> getMainCourse(){
        List<Food> lunches = getAllLunchAsFood();
        List<Food> mainCourse = new ArrayList<Food>();
        
        for(Food food : lunches){
            if(food.getCategory().equals("main_menu")){
                mainCourse.add(food);
            }
        }
        
        return mainCourse;
    }
    
    public List<Food> getMainCourse(){
        List<Food> lunches = getAllLunchAsFood();
        List<Food> mainCourse = new ArrayList<Food>();
        
        for(Food food : lunches){
            if(food.getCategory().equals("main_menu")){
                mainCourse.add(food);
            }
        }
        
        return mainCourse;
    }
    
    public List<Food> getChildMenu(){
        List<Food> lunches = getAllLunchAsFood();
        List<Food> childMenu = new ArrayList<Food>();
        
        for(Food food : lunches){
            if(food.getCategory().equals("child_menu")){
                childMenu.add(food);
            }
        }
        
        return childMenu;
    }
    
    public List<Food> getStarter(){
        List<Food> lunches = getAllLunchAsFood();
        List<Food> starter = new ArrayList<Food>();
        
        for(Food food : lunches){
            if(food.getCategory().equals("appetizer_menu")){
                starter.add(food);
            }
        }
        
        return starter;
    }
    
    public List<Food> getDessert(){
        List<Food> lunches = getAllLunchAsFood();
        List<Food> dessert = new ArrayList<Food>();
        
        for(Food food : lunches){
            if(food.getCategory().equals("desset_menu")){
                dessert.add(food);
            }
        }
        
        return dessert;
    }

}

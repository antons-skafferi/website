/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.core;

import entities.Food;
import facade.FoodFacade;
import entities.Lunch;
import facade.LunchFacade;
import java.io.Serializable;
import java.sql.Date;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author JohnE
 */
@Named(value = "lunchbean")
@SessionScoped
public class LunchBean implements Serializable {

    private String lunchId;
    private int foodId;
    private Date date;
    private int price;

    @EJB
    private LunchFacade lunchFacade;
    @EJB
    private FoodFacade foodFacade;

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
    
    public List<Food> getAllLunchAsFood(){
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
            if(food.getCategory().equals("dessert_menu")){
                dessert.add(food);
            }
        }
        return dessert;
    }
    
    public Lunch getLunch(Food food){
        List<Lunch> lunches = lunchFacade.findAll();
        for(Lunch lunch : lunches){
            if(lunch.getFoodId() == food.getFoodId()){
                return lunch;
            }
        }
        return null;
    }
    
    public Food getFood(Lunch lunch){
        List<Food> allFood = foodFacade.findAll();
        for(Food food : allFood){
            if(food.getFoodId() == lunch.getFoodId()){
                return food;
            }
        }
        return null;
    }
    
    public List<Food> getTodaysLunch() {
        List<Lunch> lunchList = lunchFacade.findAll();
        ZoneId z = ZoneId.of( "Europe/Stockholm" );
        ZonedDateTime zdt = ZonedDateTime.now( z );

        List<Food> todaysLunch = new ArrayList<>();
        for(Lunch lunch : lunchList){
            ZonedDateTime lunchZdt = lunch.getDate().toInstant().atZone(z);

            if(lunchZdt.getYear() == zdt.getYear() &&
                    lunchZdt.getMonth() == zdt.getMonth() &&
                    lunchZdt.getDayOfWeek() == zdt.getDayOfWeek()){
                todaysLunch.add(getFood(lunch));
            }
        }
        return todaysLunch;
    }
}

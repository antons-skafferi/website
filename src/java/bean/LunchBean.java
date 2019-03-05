/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Food;
import entities.Lunch;
import facade.FoodFacade;
import entities.Lunch;
import facade.LunchFacade;
import java.io.Serializable;
import java.sql.Date;
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

    private List<String> selectedLunchIDs;
 
    java.util.Date uDate = new java.util.Date();
    java.sql.Date sDate = convertUtilToSql(uDate);

    @EJB
    private LunchFacade lunchFacade;
    @EJB
    private FoodFacade foodFacade;
    
    @Inject
    private FoodBean foodBean; // +setter (no getter!)

    public void setFoodBean(FoodBean foodBean) {
        this.foodBean = foodBean;
    }

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
            if(food.getCategory().equals("desset_menu")){
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
    
    public List<String> getSelectedLunchIDs() {
        return selectedLunchIDs;
    }

    public void setSelectedLunchIDs(List<String> selectedLunchIDs) {
        this.selectedLunchIDs = selectedLunchIDs;
    }

    public List<Lunch> lunchList() {
        return lunchFacade.findAll();
    }

    public void deleteLunch() {
        for (String lunchID : selectedLunchIDs) {
            lunchFacade.deleteLunch(lunchID);
        }
    }

    public void addLunch() {
    
      for (Integer foodID : foodBean.getSelectedFoodIDs()) {
          System.out.print(lunchId);
          System.out.print(foodID);
          System.out.print(sDate);
          
            lunchFacade.create(new Lunch("lunch"+foodID.toString(), foodID, sDate, 100) );
       }

    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}

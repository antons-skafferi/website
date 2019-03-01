package bean;

import entities.Food;
import entities.Lunch;
import entities.Staff;
import facade.FoodFacade;
import facade.LunchFacade;
import facade.StaffFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Gustav
 */
@Named(value = "mainController")
@Dependent
public class MainController {
    @PersistenceContext (unitName = "websitePU")
    private EntityManager em;
    
  
    
    public List<Lunch> listAllLunch(){
        return em.createNamedQuery("Dinner.findAll", Lunch.class).getResultList();
    }
    
    @EJB
    private LunchFacade lunchFacade;
    private FoodFacade foodFacade;

    /**
     * Creates a new instance of MainController
     */
    public MainController() {
        

    }
    
        public List<Lunch> lunchList(){  
            return lunchFacade.findAll();
        }
        
        public List<Food> foodLunchList(){
            List<Lunch> lunches = lunchList();
            List<Food> allFood = foodFacade.findAll();
            List<Food> foodLunches = new ArrayList<Food>();
            for(Lunch lunch : lunches){
                for(Food food : allFood){
                    if(lunch.getFoodId() == food.getFoodId()){
                        foodLunches.add(food);
                    }
                }
            }
            return foodLunches;
        }
        
        public void addForm(String staff_id, String firstname, String lastname, String adress, String phone, String email) {
           System.out.println("hej");
          
           System.out.println(staff_id);
           //Staff newStaff = new Staff(staff_id,firstname,lastname,adress,phone,email);
           // staffFacade.create(newStaff);
            
        }
    
}

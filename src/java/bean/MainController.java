package bean;

import entities.Lunch;
import entities.Staff;
import facade.LunchFacade;
import facade.StaffFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tobias
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
    private StaffFacade staffFacade;

    /**
     * Creates a new instance of MainController
     */
    public MainController() {
        

    }
    
        public List<Lunch> lunchList(){            
            return lunchFacade.findAll();
        }
        
        public void addForm(String staff_id, String firstname, String lastname, String adress, String phone, String email) {
           System.out.println("hej");
          
           System.out.println(staff_id);
           //Staff newStaff = new Staff(staff_id,firstname,lastname,adress,phone,email);
           // staffFacade.create(newStaff);
            
        }
    
}

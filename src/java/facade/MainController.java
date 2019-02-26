package facade;

import entities.Lunch;
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

    /**
     * Creates a new instance of MainController
     */
    public MainController() {
        

    }
    
        public List<Lunch> lunchList(){            
            return lunchFacade.findAll();
        }

    
}

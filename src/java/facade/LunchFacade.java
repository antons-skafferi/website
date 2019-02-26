/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Lunch;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tobias
 */
@Stateless
public class LunchFacade extends AbstractFacade<Lunch> {

    @PersistenceContext(unitName = "websitePU")
    private EntityManager em;
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LunchFacade() {
        super(Lunch.class);
    }
    public List <Lunch> findalllunch() {
        return em.createNamedQuery("Lunch.findAll", Lunch.class).getResultList();
         
    }
    
}

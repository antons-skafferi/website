/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Dinner;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tobias
 */
@Stateless
public class DinnerFacade extends AbstractFacade<Dinner> {

    @PersistenceContext(unitName = "websitePU")
    private EntityManager em;

    public DinnerFacade() {
        super(Dinner.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public void deleteDinner(String dinnerID) {
        Dinner dinner = find(dinnerID);
        remove(dinner);
    }
}

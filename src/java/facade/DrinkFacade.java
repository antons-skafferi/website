/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Drink;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tobias
 */
@Stateless
public class DrinkFacade extends AbstractFacade<Drink> {

    @PersistenceContext(unitName = "websitePU")
    private EntityManager em;

    public DrinkFacade() {
        super(Drink.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}

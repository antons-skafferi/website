/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Food;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tobias
 */
@Stateless
public class FoodFacade extends AbstractFacade<Food> {

    @PersistenceContext(unitName = "websitePU")
    private EntityManager em;

    public FoodFacade() {
        super(Food.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public void deleteFood(int foodID) {
        Food food = find(foodID);
        remove(food);

        //em.createNamedQuery("Food.deleteByFoodId").setParameter("foodId", foodID);
    }

}

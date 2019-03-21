/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Images;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tobias
 */
@Stateless
public class ImagesFacade extends AbstractFacade<Images> {

    @PersistenceContext(unitName = "websitePU")
    private EntityManager em;

    public ImagesFacade() {
        super(Images.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}

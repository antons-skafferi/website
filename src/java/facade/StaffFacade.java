/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Staff;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tobias
 */
@Stateless
public class StaffFacade extends AbstractFacade<Staff> {

    @PersistenceContext(unitName = "websitePU")
    private EntityManager em;

    public StaffFacade() {
        super(Staff.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public void deleteStaff(String staffID) {
        Staff staff = find(staffID);
        remove(staff);
    }

}

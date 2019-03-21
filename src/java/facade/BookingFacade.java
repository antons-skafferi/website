/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Booking;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tobias
 */
@Stateless
public class BookingFacade extends AbstractFacade<Booking> {

    @PersistenceContext(unitName = "websitePU")
    private EntityManager em;

    public BookingFacade() {
        super(Booking.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public void deleteBooking(int bookingID) {
        Booking booking = find(bookingID);
        remove(booking);
    }

}

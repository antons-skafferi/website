/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.core;

import entities.Event;
import facade.EventFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

@Named(value = "eventBean")
@SessionScoped
public class EventBean implements Serializable {
    @EJB  
    private EventFacade eventFacade;
    
    
    public List<Event> getUpcomingEvents(int count){
        List<Event> events = eventFacade.findAll();
        Calendar now = Calendar.getInstance();
        // Using -1 be sure to get current and coming events
        now.set(Calendar.HOUR, -1);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        Date currentDate = now.getTime();
        events.removeIf(e -> e.getEventDate().before(currentDate));
        events.sort(Comparator.comparing(Event::getEventDate));
        
        if(count > events.size()){
            count = events.size();
        }
        
        return events.subList(0, count);
    }
    
    public List<Event> getEventsAfter(int count){
        List<Event> events = eventFacade.findAll();
        Calendar now = Calendar.getInstance();
        // Using -1 to only get events that has passed
        now.set(Calendar.HOUR, -1);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        Date currentDate = now.getTime();
        events.removeIf(e -> e.getEventDate().after(currentDate) ||
                e.getEventDate().equals(e));
        events.sort(Comparator.comparing(Event::getEventDate).reversed());
        
        if(count > events.size()){
            count = events.size();
        }
        
        return events.subList(0, count);
    }

}

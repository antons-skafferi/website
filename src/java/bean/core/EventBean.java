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
import java.util.Comparator;
import java.util.List;
import javax.ejb.EJB;

@Named(value = "eventBean")
@SessionScoped
public class EventBean implements Serializable {
    @EJB  
    private EventFacade eventFacade;
    
    
    public List<Event> getUpcomingEvents(int count){
        List<Event> events = eventFacade.findAll();       
        events.sort(Comparator.comparing(Event::getEventDate));
        
        if(count > events.size()){
            count = events.size();
        }
        
        return events.subList(0, count);
    }
    
    public List<Event> getEventsAfter(int count){
        List<Event> events = eventFacade.findAll();       
        events.sort(Comparator.comparing(Event::getEventDate));
        
        if(count >= events.size())
            return new ArrayList<Event>();
        
        return events.subList(count, events.size());
    }

}

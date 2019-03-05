/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Event;
import facade.EventFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.text.ParseException;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Max Wågberg
 */
@Named(value = "eventBean")
@SessionScoped
public class eventBean implements Serializable {

    private String event_id;
    private String description;
    private String image;
    private String strDate;
    private Date event_date;
    private String event_title;
    
    private List<Integer> selectedEventIDs;
    
    @EJB
    private EventFacade eventFacade;
    
    public List<Integer> getSelectedEventIDs() {
        return selectedEventIDs;
    }
    
    public void setSelectedEventIDs(List<Integer> selectedEventIDs){
        this.selectedEventIDs = selectedEventIDs;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }
    
    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }
    
    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }
    
    public List<Event> eventList(){
        return eventFacade.findAll();
    }
    
    public void addEventForm() throws ParseException{
        java.sql.Date sqlDate = new java.sql.Date(event_date.getTime());

        eventFacade.create(new Event(null, sqlDate, event_title));
    }
    
    public void deleteEvent() {
        for (Integer eventID : selectedEventIDs) {
            eventFacade.deleteEvent(eventID);
        }
    }
    
}

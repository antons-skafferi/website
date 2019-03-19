/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.staff;

import entities.Event;
import facade.EventFacade;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author gustav
 */
@Named(value = "staffEventBean")
@ManagedBean
@SessionScoped
public class StaffEventBean implements Serializable {
    private String event_id;
    private String description;
    private String strDate;
    private Date event_date;
    private String event_title;
    
    private List<Integer> selectedEventIDs;
    
    @EJB
    private EventFacade eventFacade;
    
    private UploadedFile file;
 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
     
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
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

    public Date getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }

    public List<Event> eventList() {
        return eventFacade.findAll();
    }
    
 

    public void addEventForm() throws ParseException, FileNotFoundException, IOException{
        int x = 0;
        java.sql.Date sqlDate = new java.sql.Date(event_date.getTime());


        InputStream input = null;
        OutputStream output = null;
        String filename = FilenameUtils.getName(file.getFileName());
        File newFile = new File("/antonsskafferi/events", filename);
        String newFilePath = newFile.toPath().toString();
        newFile.getParentFile().mkdirs();
                    
            input = file.getInputstream();
            output = FileUtils.openOutputStream(newFile);
        try {

            IOUtils.copy(input, output);
        } catch (IOException ex) {
            Logger.getLogger(StaffEventBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(output);
        }
        
        if (description == null) {
            if (file == null) {
                eventFacade.create(new Event(null, sqlDate, event_title));
            }
            eventFacade.create(new Event(null, sqlDate, event_title, newFilePath));
        } else if (file == null) {
            eventFacade.create(new Event(null, description, sqlDate, event_title));
        } else {
            eventFacade.create(new Event(null, sqlDate, event_title, description, newFilePath));
        }
        
        

    }
    
    public void deleteEvent() {
        for (Integer eventID : selectedEventIDs) {
            eventFacade.deleteEvent(eventID);
        }
    }
    /**
     * Creates a new instance of StaffEventBean
     */
    public StaffEventBean() {
    }
    
}

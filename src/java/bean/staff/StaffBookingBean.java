/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.staff;

import com.sun.xml.wss.util.DateUtils;
import entities.Booking;
import entities.Dinnertable;
import facade.BookingFacade;
import facade.DinnertableFacade;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.util.Calendar.HOUR;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Max Wågberg
 */
@Named(value = "staffBookingBean")
@ManagedBean
@SessionScoped
public class StaffBookingBean implements Serializable {
    private String bookingId;
    private String talbeId;
    private int people;
    private Date bookingFrom;
    private Date bookingTo;
    private Date bookingDate;
    private String name;
    private String lastname;
    private String phone;
    private String email;
    private String bookingDescription;
    private String strBookingFrom;
    
    private List<Integer> selectedBookingIDs;

    
    @EJB
    private BookingFacade bookingFacade;
    @EJB
    private DinnertableFacade dinnertableFacade;
    
    public List<Integer> getSelectedBookingIDs() {
        return selectedBookingIDs;
    }
    
    public void setSelectedBookingIDs(List<Integer> selectedBookingIDs){
        this.selectedBookingIDs = selectedBookingIDs;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getTalbeId() {
        return talbeId;
    }

    public void setTalbeId(String talbeId) {
        this.talbeId = talbeId;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public Date getBookingFrom() {
        return bookingFrom;
    }

    public void setBookingFrom(Date bookingFrom) {
        this.bookingFrom = bookingFrom;
    }

    public Date getBookingTo() {
        return bookingTo;
    }

    public void setBookingTo(Date bookingTo) {
        this.bookingTo = bookingTo;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<Booking> bookingList() {
        return bookingFacade.findAll();
    }

    public String getBookingDescription() {
        return bookingDescription;
    }

    public void setBookingDescription(String bookingDescription) {
        this.bookingDescription = bookingDescription;
    }

    public String getStrBookingFrom() {
        return strBookingFrom;
    }

    public void setStrBookingFrom(String strBookingFrom) {
        this.strBookingFrom = strBookingFrom;
    }
    
    public void addBookingForm() throws ParseException {
        
        int x = 0;
        java.sql.Date sqlDate = new java.sql.Date(bookingDate.getTime());
        
        /*String testStartTime = "10:00:00";
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
        java.util.Date startTime = sdf1.parse(testStartTime);
        java.sql.Date sqlStartTime = new java.sql.Date(startTime.getTime());
        
        System.out.println(sqlStartTime);
        System.out.println(sqlDate);*/
        
        java.util.Date tempTime = new SimpleDateFormat("HH:mm:ss")
                .parse(strBookingFrom);
        
        //Not working atm
        java.util.Date tempTime2 = (java.util.Date) tempTime.clone();
        
        tempTime2.setTime(tempTime.getTime() + TimeUnit.HOURS.toMillis(2));
        
        if(bookingDescription != null){
            if(name.contains(" ")){ 
                String[] splittedNames = name.split(" ");
                name = splittedNames[0];
                lastname = splittedNames[1];
                bookingFacade.create(new Booking(null, "1", people, tempTime, tempTime2, sqlDate, name, lastname, phone, email, bookingDescription));
            }
            else{
                bookingFacade.create(new Booking(null, "1", people, tempTime, tempTime2, sqlDate, name, "templast", phone, email, bookingDescription));

            }
        }
        else{
            if(name.contains(" ")){ 
                String[] splittedNames = name.split(" ");
                name = splittedNames[0];
                lastname = splittedNames[1];
                bookingFacade.create(new Booking(null, "1", people, tempTime, tempTime2, sqlDate, name, lastname, phone, email));
            }
            else{
                bookingFacade.create(new Booking(null, "1", people, tempTime, tempTime2, sqlDate, name, "templast", phone, email));

            }
        }
        
       
        
    }
    
    public void deleteBooking() {
        for (Integer bookingID : selectedBookingIDs) {
            bookingFacade.deleteBooking(bookingID);
        }
    }
     
    public List<Dinnertable> availableTables(Date date){
        List<Booking> Booked = bookingFacade.findAll();
        List<Dinnertable> tables = dinnertableFacade.findAll();
        List<Dinnertable> availableTables = new ArrayList<Dinnertable>();
        List<Dinnertable> bookedTables = new ArrayList<Dinnertable>();
        
        Date dateEnd = (Date) date.clone();
        dateEnd.setTime(dateEnd.getTime() + TimeUnit.HOURS.toMillis(1));
        
        for(Booking booked : Booked){
            
           if(booked.getBookingDate().equals(date) || booked.getBookingDate().equals(dateEnd)){
                for(Dinnertable table : tables){
                    if(booked.getTableId().equals(table.getTableId())){
                        bookedTables.add(table);
                    }
                }
           }
        }
        
        for(Dinnertable table : tables){
                if(!bookedTables.contains(table)){
                    availableTables.add(table);
                }
        }
        return availableTables;
     } 

}

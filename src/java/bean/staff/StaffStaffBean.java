/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.staff;

import entities.Food;
import entities.Staff;
import facade.StaffFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author gustav
 */
@Named(value = "staffStaffBean")
@ManagedBean
@SessionScoped
public class StaffStaffBean implements Serializable {

    @EJB
    private StaffFacade staffFacade;

    private List<String> selectedStaffIDs;

    private String staffId;
    private String firstname;
    private String lastname;
    private String adress;
    private String phone;
    private String email;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public List<String> getSelectedStaffIDs() {
        return selectedStaffIDs;
    }

    public void setSelectedStaffIDs(List<String> selectedStaffIDs) {
        this.selectedStaffIDs = selectedStaffIDs;
    }

    public List<Staff> getStaff() {
        return staffFacade.findAll();
    }

    public void addStaffForm() {
        staffFacade.create(new Staff(staffId, firstname, lastname, adress, phone, email));
    }

    public void deleteStaff() {
        for (String staffID : selectedStaffIDs) {
            staffFacade.deleteStaff(staffID);
        }
    }
}

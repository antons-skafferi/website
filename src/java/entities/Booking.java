/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Max Wågberg
 */
@Entity
@Table(name = "booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
    , @NamedQuery(name = "Booking.findByBookingId", query = "SELECT b FROM Booking b WHERE b.bookingId = :bookingId")
    , @NamedQuery(name = "Booking.findByTableId", query = "SELECT b FROM Booking b WHERE b.tableId = :tableId")
    , @NamedQuery(name = "Booking.findByPeople", query = "SELECT b FROM Booking b WHERE b.people = :people")
    , @NamedQuery(name = "Booking.findByBookingFrom", query = "SELECT b FROM Booking b WHERE b.bookingFrom = :bookingFrom")
    , @NamedQuery(name = "Booking.findByBookingTo", query = "SELECT b FROM Booking b WHERE b.bookingTo = :bookingTo")
    , @NamedQuery(name = "Booking.findByBookingDate", query = "SELECT b FROM Booking b WHERE b.bookingDate = :bookingDate")
    , @NamedQuery(name = "Booking.findByName", query = "SELECT b FROM Booking b WHERE b.name = :name")
    , @NamedQuery(name = "Booking.findByLastname", query = "SELECT b FROM Booking b WHERE b.lastname = :lastname")
    , @NamedQuery(name = "Booking.findByPhone", query = "SELECT b FROM Booking b WHERE b.phone = :phone")
    , @NamedQuery(name = "Booking.findByEmail", query = "SELECT b FROM Booking b WHERE b.email = :email")
    , @NamedQuery(name = "Booking.findByBookingDescription", query = "SELECT b FROM Booking b WHERE b.bookingDescription = :bookingDescription")
    , @NamedQuery(name = "Booking.findByStringBookingFrom", query = "SELECT b FROM Booking b WHERE b.stringBookingFrom = :stringBookingFrom")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "booking_id")
    private Integer bookingId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "table_id")
    private String tableId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "people")
    private int people;
    @Basic(optional = false)
    @NotNull
    @Column(name = "booking_from")
    @Temporal(TemporalType.TIME)
    private Date bookingFrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "booking_to")
    @Temporal(TemporalType.TIME)
    private Date bookingTo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "booking_date")
    @Temporal(TemporalType.DATE)
    private Date bookingDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lastname")
    private String lastname;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "booking_description")
    private String bookingDescription;
    @Size(max = 255)
    @Column(name = "string_booking_from")
    private String stringBookingFrom;

    public Booking() {
    }

    public Booking(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Booking(Integer bookingId, String tableId, int people, Date bookingFrom, Date bookingTo, Date bookingDate, String name, String lastname, String phone, String email) {
        this.bookingId = bookingId;
        this.tableId = tableId;
        this.people = people;
        this.bookingFrom = bookingFrom;
        this.bookingTo = bookingTo;
        this.bookingDate = bookingDate;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
    }

    public Booking(Integer bookingId, String tableId, int people, Date bookingFrom, Date bookingTo, Date bookingDate, String name, String lastname, String phone, String email, String bookingDescription) {
        this.bookingId = bookingId;
        this.tableId = tableId;
        this.people = people;
        this.bookingFrom = bookingFrom;
        this.bookingTo = bookingTo;
        this.bookingDate = bookingDate;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.bookingDescription = bookingDescription;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
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

    public String getBookingDescription() {
        return bookingDescription;
    }

    public void setBookingDescription(String bookingDescription) {
        this.bookingDescription = bookingDescription;
    }

    public String getStringBookingFrom() {
        return stringBookingFrom;
    }

    public void setStringBookingFrom(String stringBookingFrom) {
        this.stringBookingFrom = stringBookingFrom;
    }

    public String getFullInfo() {
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM-yyyy");

        String bookingStartDate = sdfDate.format(getBookingDate());
        String bookingStartTime = sdfTime.format(getBookingFrom());
        String bookingEndTime = sdfTime.format(getBookingTo());

        return getName() + " " + getLastname() + "-" + bookingStartDate + " Från " + bookingStartTime + " Till " + bookingEndTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingId != null ? bookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingId == null && other.bookingId != null) || (this.bookingId != null && !this.bookingId.equals(other.bookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Booking[ bookingId=" + bookingId + " ]";
    }

}

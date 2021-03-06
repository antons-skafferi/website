/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Format;
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
@Table(name = "event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")
    , @NamedQuery(name = "Event.findByEventId", query = "SELECT e FROM Event e WHERE e.eventId = :eventId")
    , @NamedQuery(name = "Event.findByDescription", query = "SELECT e FROM Event e WHERE e.description = :description")
    , @NamedQuery(name = "Event.findByImage", query = "SELECT e FROM Event e WHERE e.image = :image")
    , @NamedQuery(name = "Event.findByEventDate", query = "SELECT e FROM Event e WHERE e.eventDate = :eventDate")
    , @NamedQuery(name = "Event.findByEventTitle", query = "SELECT e FROM Event e WHERE e.eventTitle = :eventTitle")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "event_id")
    private Integer eventId;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "event_date")
    @Temporal(TemporalType.DATE)
    private Date eventDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "event_title")
    private String eventTitle;

    public Event() {
    }

    public Event(Integer eventId) {
        this.eventId = eventId;
    }

    public Event(Integer eventId, Date eventDate, String eventTitle) {
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.eventTitle = eventTitle;
    }

    public Event(Integer eventId, Date eventDate, String eventTitle, String image) {
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.eventTitle = eventTitle;
        this.image = image;
    }

    public Event(Integer eventId, String description, Date eventDate, String eventTitle) {
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.eventTitle = eventTitle;
        this.description = description;
    }

    public Event(Integer eventId, Date eventDate, String eventTitle, String description, String image) {
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.eventTitle = eventTitle;
        this.description = description;
        this.image = image;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
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

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDateFormated() {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(eventDate);
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getImageFileName() {
        Path p = Paths.get(image);
        String stringPath = p.getFileName().toString();
        return stringPath;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Event[ eventId=" + eventId + " ]";
    }

}

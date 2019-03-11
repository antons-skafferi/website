/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.core;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.javaIdentifierType;
import entities.Event;
import facade.EventFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.text.ParseException;
import java.util.List;
import javax.ejb.EJB;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Max Wågberg
 */
@Named(value = "eventBean")
@SessionScoped
public class EventBean implements Serializable {


    
}

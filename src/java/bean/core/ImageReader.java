/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author gustav
 */
@Named(value = "imageReader")
@ApplicationScoped
public class ImageReader {

    public InputStream getImageByPath(String filename) throws FileNotFoundException {
        return new FileInputStream(new File(filename));
    }
}

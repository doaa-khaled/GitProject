/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author DELL
 */
public class ImgModel {
    protected BufferedImage img;
    protected String creationDateString;
    
    public ImgModel(File imageFile)
    {
        Path file = Paths.get(imageFile.toURI());
        BasicFileAttributes attr = null;
        try {
            img = ImageIO.read(imageFile);
            attr = Files.readAttributes(file, BasicFileAttributes.class);
        } catch (IOException ex) {
            Logger.getLogger(ImgModel.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        creationDateString = attr.creationTime().toString(); //temp
    }
    public void setImage (BufferedImage imageObject)
    {
        img = imageObject;
    }
    public BufferedImage getImage ()
    {
        return this.img;
    }
    public void setCreationDate (String creattionDate)
    {
        this.creationDateString = creattionDate;
    }
    public String getCreationDate ()
    {
        return this.creationDateString;
    }
}

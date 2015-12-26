/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import java.awt.color.ColorSpace;
import static java.awt.color.ColorSpace.CS_GRAY;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author DELL
 */
public class ImageUtilites {
    
    /**
     *
     * @param filePath
     * @param img
     */

    public static void saveImage (String filePath, BufferedImage img)
    {
        File outFile = new File(filePath + "/image.png");
        try {
            ImageIO.write(img, "PNG", outFile);
        } catch (IOException ex) {
            Logger.getLogger(ImageUtilites.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static BufferedImage applyInvertedFilter (BufferedImage sourceImage)
    {
        RescaleOp op = new RescaleOp(-1.0f, 255f, null);
        BufferedImage invertedImage = op.filter(sourceImage, null);
        return invertedImage;
    }
    public static BufferedImage applyGrayScaledFilter (BufferedImage sourceImage)
    {
        ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(CS_GRAY), null);
        BufferedImage invertedImage = op.filter(sourceImage, null);
        return invertedImage;
    }
}

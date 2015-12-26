/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImageEditor.resources;

import Bussiness.ImageUtilites;
import Model.ImgModel;
import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author DELL
 */

public class ImageContainer extends javax.swing.JFrame {
    
    private float scale = 1; 
    int xPosition , yPosition;
    Point startPoint, endPoint;
    int moveFlag = 0;
    final int menuBarWidth = 50;
    int releaseFlag = 0;
    int dragFlag = 0;
    static ImgModel imgObj;  
    private static ImageContainer imageContainer;
    
    private ImageContainer (ImgModel imgObj){
        
        initComponents();        
        this.setResizable(false);
        
        ImageContainer.imgObj = imgObj;
        startPoint = endPoint = null;
        
        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                BufferedImage img = ImageContainer.imgObj.getImage();
                if(moveFlag == 0)
                {
                    xPosition = (500 - (img.getWidth()/2));
                    yPosition = (275 - (img.getHeight()/2));
                }
                g.drawImage(img, xPosition, yPosition, null);
                if(startPoint!= null && endPoint!= null)
                {
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setStroke(new BasicStroke(3));
                     
                    g2.drawLine(startPoint.x, startPoint.y-menuBarWidth, endPoint.x, endPoint.y-menuBarWidth);
                    endPoint = null;
                }
                if (releaseFlag == 1)
                {
//                    BufferedImage capturedImg = null;
//                    Rectangle screenRect = new Rectangle(xPosition, yPosition, ImageContainer.imgObj.getImage().getWidth(), ImageContainer.imgObj.getImage().getHeight());
//                    try {
//                        capturedImg= new Robot().createScreenCapture(screenRect);
//                    } catch (AWTException ex) {
//                        Logger.getLogger(ImageContainer.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                    g.drawImage(img, xPosition, yPosition, null);
                    ImageContainer.imgObj.setImage(img);
                    releaseFlag = 0;
                }
            }

        };
        pane.setSize(1000, 550);
        this.add(pane);
    }

    public static ImageContainer getInstance (ImgModel imgObj)
    {
        if(imageContainer == null)
        {
            imageContainer = new ImageContainer(imgObj);
            imageContainer.setVisible(true);
        }
        else
        {
            ImageContainer.imgObj = imgObj;
            imageContainer.repaint();
        }
        return imageContainer;
    }
       
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        imageInfo = new javax.swing.JMenuItem();
        invertImage = new javax.swing.JMenuItem();
        grayScale = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();

        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Editor");
        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        menuBar.setMaximumSize(new java.awt.Dimension(50, 32769));
        menuBar.setMinimumSize(new java.awt.Dimension(50, 21));
        menuBar.setPreferredSize(new java.awt.Dimension(50, 21));

        jMenu1.setText("Options");

        imageInfo.setText("Image Info");
        imageInfo.setName("imageInfo"); // NOI18N
        imageInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageInfoActionPerformed(evt);
            }
        });
        jMenu1.add(imageInfo);

        invertImage.setText("Invert Image");
        invertImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertImageActionPerformed(evt);
            }
        });
        jMenu1.add(invertImage);

        grayScale.setText("Gray Scale");
        grayScale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grayScaleActionPerformed(evt);
            }
        });
        jMenu1.add(grayScale);

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jMenu1.add(save);

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imageInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageInfoActionPerformed
        // TODO add your handling code here:

        JOptionPane.showMessageDialog(null, "Height: "+ imgObj.getImage().getHeight()+ "\nWidth: "+ 
                imgObj.getImage().getWidth()+"\nCreation Date: "+ imgObj.getCreationDate(), "Image Info.", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_imageInfoActionPerformed

    private void invertImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertImageActionPerformed
        // TODO add your handling code here:
        moveFlag = 0;
        imgObj.setImage(ImageUtilites.applyInvertedFilter(imgObj.getImage()));
        repaint();
    }//GEN-LAST:event_invertImageActionPerformed

    private void grayScaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grayScaleActionPerformed
        // TODO add your handling code here:
        moveFlag = 0;
        imgObj.setImage(ImageUtilites.applyGrayScaledFilter(imgObj.getImage()));
        repaint();        
    }//GEN-LAST:event_grayScaleActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        moveFlag = 0;
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getCurrentDirectory();
            ImageUtilites.saveImage(file.getAbsolutePath(), imgObj.getImage());
        }
    }//GEN-LAST:event_saveActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
        // TODO add your handling code here:
        moveFlag = 0;
        double delta = 0.08f * evt.getPreciseWheelRotation();
        scale +=delta;
        int newHeight = ((int) (scale*imgObj.getImage().getHeight()));
        int newWidth = ((int) (scale*imgObj.getImage().getWidth()));
        if((newHeight > 550 || newHeight <40)||(newWidth > 1000 || newWidth< 80))
            ;
        else{
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
            AffineTransform affTrans = new AffineTransform();
            affTrans.scale(scale, scale);
            AffineTransformOp scaleOp = new AffineTransformOp(affTrans, AffineTransformOp.TYPE_BILINEAR);
            resizedImage = scaleOp.filter(imgObj.getImage(), resizedImage);
            imgObj.setImage(resizedImage);
            repaint();
        }        
    }//GEN-LAST:event_formMouseWheelMoved

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged

       dragFlag = 1;
        if(SwingUtilities.isLeftMouseButton(evt))
        {            
            xPosition = evt.getX();
            yPosition = evt.getY()-menuBarWidth;
            moveFlag = 1;
        }else if(SwingUtilities.isRightMouseButton(evt))
        {
            if(startPoint == null)
                startPoint = endPoint = evt.getPoint();
            else
                endPoint = evt.getPoint();
            moveFlag = 0;
        }
        repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
        if(dragFlag == 1)
        {
            dragFlag = 0;
            releaseFlag = 1;       
        }
    }//GEN-LAST:event_formMouseReleased

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem exit;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenuItem grayScale;
    private javax.swing.JMenuItem imageInfo;
    private javax.swing.JMenuItem invertImage;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem save;
    // End of variables declaration//GEN-END:variables
}

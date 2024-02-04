/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jframe;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author nirma
 */
public class Func_Class {
    
    public void displayImage(int width, int height, byte[] imageByte, JLabel label){
        
        // Get image
        ImageIcon imgIcon;
        
        // Get image using bytes
            
        imgIcon = new ImageIcon(imageByte);
        
        // Make the image fit in jlabel
        Image image = imgIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
        // Set the image to JLabel
        label.setIcon(new ImageIcon(image));
        
    }
}

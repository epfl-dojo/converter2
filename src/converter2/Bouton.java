/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter2;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author chocomoon
 */
public class Bouton extends JButton{
    
    private String buttonName;
    
    public Bouton(String str, Color bgColor, Color fgColor, Font bFont) {
        super(str);
        
        this.buttonName=str;
        this.setBackground(bgColor);
        this.setForeground(fgColor);
        
        this.setFont(bFont);
        

    }
    
}

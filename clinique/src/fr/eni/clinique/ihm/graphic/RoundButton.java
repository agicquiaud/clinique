package fr.eni.clinique.ihm.graphic;

import java.awt.*;

import javax.swing.border.Border;

 
public class RoundButton implements Border {

    private int radius;


    public RoundButton(int radius) {
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
    	
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        
    }


    public boolean isBorderOpaque() {
        return false;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    	g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        
    }
}
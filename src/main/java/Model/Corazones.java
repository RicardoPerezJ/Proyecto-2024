/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.ImageIcon;

/**
 *
 * @author Ricardo
 */
public class Corazones {
    private ImageIcon corazon; 
    private int posX, posY;

    public Corazones() {
        
    }

    public Corazones(ImageIcon corazon, int posX, int posY) {
        this.corazon = corazon;
        this.posX = posX;
        this.posY = posY;
    }

    public ImageIcon getCorazon() {
        return corazon;
    }

    public void setCorazon(ImageIcon corazon) {
        this.corazon = corazon;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    
    
    
    
}

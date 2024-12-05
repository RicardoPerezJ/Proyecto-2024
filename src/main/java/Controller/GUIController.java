/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Protagonista;
import View.FrameHistoria;
import View.FrameInstrucciones;
import View.FrameLaberinto;
import View.FrameMenu;
import View.Laberinto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Ricardo
 */
public class GUIController implements ActionListener, KeyListener {

    private FrameMenu frameMenu;
    private Personajes personajes;
    private FrameLaberinto laberinto;

    public GUIController() {

        frameMenu = new FrameMenu();

        laberinto = frameMenu.getFramelaberinto();

        personajes = new Personajes();

        frameMenu.setVisible(true);

        this.frameMenu.listenerButton(this);

    }

    public FrameMenu getFrameMenu() {
        return frameMenu;
    }

    public void setFrameMenu(FrameMenu frameMenu) {
        this.frameMenu = frameMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Play":
                frameMenu.setFrameLaberinto(new FrameMenu().getFramelaberinto());
                this.frameMenu.listenerButton(this);
                frameMenu.getFramelaberinto().listenKey(this);
                frameMenu.getFramelaberinto().setVisible(true);
                frameMenu.setVisible(false);
                frameMenu.getFramelaberinto().panelLab().setFocusable(true);
                break;

            case "Instrucciones":
                frameMenu.instruccionesPanel().setVisible(true);
                frameMenu.setVisible(false);
                break;

            case "Historia":
                frameMenu.historiaPanel().setVisible(true);
                frameMenu.setVisible(false);
                break;

            case "Salir":
                System.exit(0);
                break;

            case "Regresar":
                frameMenu.historiaPanel().setVisible(false);
                frameMenu.instruccionesPanel().setVisible(false);
                frameMenu.getFramelaberinto().setVisible(false);

                frameMenu = new FrameMenu();
                frameMenu.setVisible(true);
                frameMenu.listenerButton(this);

                break;

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int dx = 0, dy = 0;
        switch (e.getKeyCode()) {

            case KeyEvent.VK_UP -> {

                
                    dy = -1;

                    frameMenu.getFramelaberinto().panelLab().getProtagonista().setProta(frameMenu.getFramelaberinto().panelLab().getProtagonista().getAtras());
                    frameMenu.getFramelaberinto().getMensajesLabel().setText(frameMenu.getFramelaberinto().panelLab().getTxt());
                    frameMenu.getFramelaberinto().panelLab().getProtagonista().mover(dx, dy);
                    frameMenu.getFramelaberinto().repaint();
                
                if (frameMenu.getFramelaberinto().panelLab().getProtagonista().isEstado() == true) {
                    this.frameMenu.getFrameGanar().keyListener(this);

                    frameMenu.getFramelaberinto().setVisible(false);
                    frameMenu.getFrameGanar().setVisible(true);
                    frameMenu.getFrameGanar().setFocusable(true);
                }
                if (frameMenu.getFramelaberinto().panelLab().getProtagonista().isPerder() == true) {
                    this.frameMenu.getFramePerderd().keyListener(this);
                    frameMenu.getFramelaberinto().setVisible(false);
                    frameMenu.getFramePerderd().setVisible(true);
                    frameMenu.getFramePerderd().setFocusable(true);
                }
            }
            case KeyEvent.VK_DOWN -> {

                
                    dy = 1;

                    frameMenu.getFramelaberinto().panelLab().getProtagonista().setProta(frameMenu.getFramelaberinto().panelLab().getProtagonista().getFrente());
                    frameMenu.getFramelaberinto().getMensajesLabel().setText(frameMenu.getFramelaberinto().panelLab().getTxt());
                    frameMenu.getFramelaberinto().panelLab().getProtagonista().mover(dx, dy);
                    frameMenu.getFramelaberinto().repaint();
                
                if (frameMenu.getFramelaberinto().panelLab().getProtagonista().isEstado() == true) {
                    this.frameMenu.getFrameGanar().keyListener(this);

                    frameMenu.getFramelaberinto().setVisible(false);
                    frameMenu.getFrameGanar().setVisible(true);
                    frameMenu.getFrameGanar().setFocusable(true);
                }
                if (frameMenu.getFramelaberinto().panelLab().getProtagonista().isPerder() == true) {
                    this.frameMenu.getFramePerderd().keyListener(this);
                    frameMenu.getFramelaberinto().setVisible(false);
                    frameMenu.getFramePerderd().setVisible(true);
                    frameMenu.getFramePerderd().setFocusable(true);
                }
            }
            case KeyEvent.VK_LEFT -> {

                
                    dx = -1;

                    frameMenu.getFramelaberinto().panelLab().getProtagonista().setProta(frameMenu.getFramelaberinto().panelLab().getProtagonista().getIzquierda());
                    frameMenu.getFramelaberinto().getMensajesLabel().setText(frameMenu.getFramelaberinto().panelLab().getTxt());
                    frameMenu.getFramelaberinto().panelLab().getProtagonista().mover(dx, dy);
                    frameMenu.getFramelaberinto().repaint();
                
                if (frameMenu.getFramelaberinto().panelLab().getProtagonista().isEstado() == true) {
                    this.frameMenu.getFrameGanar().keyListener(this);

                    frameMenu.getFramelaberinto().setVisible(false);
                    frameMenu.getFrameGanar().setVisible(true);
                    frameMenu.getFrameGanar().setFocusable(true);
                }
                if (frameMenu.getFramelaberinto().panelLab().getProtagonista().isPerder() == true) {
                    this.frameMenu.getFramePerderd().keyListener(this);
                    frameMenu.getFramelaberinto().setVisible(false);
                    frameMenu.getFramePerderd().setVisible(true);
                    frameMenu.getFramePerderd().setFocusable(true);
                }
            }
            case KeyEvent.VK_RIGHT -> {

                
                    dx = 1;

                    frameMenu.getFramelaberinto().panelLab().getProtagonista().setProta(frameMenu.getFramelaberinto().panelLab().getProtagonista().getDerecha());
                    frameMenu.getFramelaberinto().getMensajesLabel().setText(frameMenu.getFramelaberinto().panelLab().getTxt());
                    frameMenu.getFramelaberinto().panelLab().getProtagonista().mover(dx, dy);
                    frameMenu.getFramelaberinto().repaint();
                

                if (frameMenu.getFramelaberinto().panelLab().getProtagonista().isEstado() == true) {
                    this.frameMenu.getFrameGanar().keyListener(this);

                    frameMenu.getFramelaberinto().setVisible(false);
                    frameMenu.getFrameGanar().setVisible(true);
                    frameMenu.getFrameGanar().setFocusable(true);
                }
                if (frameMenu.getFramelaberinto().panelLab().getProtagonista().isPerder() == true) {
                    this.frameMenu.getFramePerderd().keyListener(this);
                    frameMenu.getFramelaberinto().setVisible(false);
                    frameMenu.getFramePerderd().setVisible(true);
                    frameMenu.getFramePerderd().setFocusable(true);
                }
            }
            case KeyEvent.VK_SPACE -> {

                frameMenu.historiaPanel().setVisible(false);
                frameMenu.instruccionesPanel().setVisible(false);
                frameMenu.getFramelaberinto().setVisible(false);
                frameMenu.getFrameGanar().setVisible(false);
                frameMenu.getFramePerderd().setVisible(false);
                frameMenu.setVisible(false);
                frameMenu = null;

                frameMenu = new FrameMenu();
                frameMenu.setVisible(true);
                frameMenu.listenerButton(this);

            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}

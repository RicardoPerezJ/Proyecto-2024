/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.Personajes;
import Model.Bounds;
import Model.Corazones;
import Model.Enemigo;
import Model.Premio;
import Model.Protagonista;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricardo
 */
public class Laberinto extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form Laberinto
     */
    private Protagonista protagonista;
    private Enemigo enemigo;
    private Bounds laberinto;
    private Personajes personajes;
    private ImageIcon muro;
    private ImageIcon camino;
    private ImageIcon[] arregloImagenes;
    private ArrayList<Enemigo> enemigos;
    private ArrayList<Premio> premios;
    private ArrayList<Corazones> corazones;
    private int premiosObtenidos, contador;
    private Thread hilo;
    private boolean todosPremios;
    private String txt;

    public Laberinto() {

        initComponents();

        txt = "";

        todosPremios = false;

        enemigos = new ArrayList();
        premios = new ArrayList();
        corazones = new ArrayList();

        personajes = new Personajes();

        laberinto = new Bounds();

        arregloImagenes = new ImageIcon[3];

        arregloImagenes[1] = new ImageIcon("./src/main/resources/pisoo.png");
        arregloImagenes[0] = new ImageIcon("./src/main/resources/muroo.png");

        muro = new ImageIcon("./src/main/resources/muroo.png");
        camino = new ImageIcon("./src/main/resources/pisoo.png");

        protagonista = new Protagonista(2, 3);
        enemigos.add(new Enemigo(7, 14, personajes.getEnemigo().getEnemigo()));
        enemigos.add(new Enemigo(20, 20, personajes.getEnemigo().getEnemigo2()));

        premios.add(new Premio(18, 21, personajes.getPremio().getPremio()));
        premios.add(new Premio(5, 21, personajes.getPremio().getPremio()));
        premios.add(new Premio(21, 21, personajes.getPremio().getPremio()));

        corazones.add(new Corazones(new ImageIcon("./src/main/resources/Corazon.png"), 855, 250));
        corazones.add(new Corazones(new ImageIcon("./src/main/resources/Corazon.png"), 915, 250));
        corazones.add(new Corazones(new ImageIcon("./src/main/resources/Corazon.png"), 970, 250));

        hilo = new Thread(this);
        hilo.start();

        contador = 5;

        this.setPreferredSize(new Dimension(1080, 810));

        setLayout(null);

    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public boolean isTodosPremios() {
        return todosPremios;
    }

    public void setTodosPremios(boolean todosPremios) {
        this.todosPremios = todosPremios;
    }

    public Protagonista getProtagonista() {
        return protagonista;
    }

    public void setProtagonista(Protagonista protagonista) {
        this.protagonista = protagonista;
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }

    public void setEnemigoUno(Enemigo enemigoUno) {
        this.enemigo = enemigoUno;
    }

    public Enemigo getEnemigoDos() {
        return enemigo;
    }

    public void setEnemigoDos(Enemigo enemigoDos) {
        this.enemigo = enemigoDos;
    }

    public Bounds getLaberinto() {
        return laberinto;
    }

    public void setLaberinto(Bounds laberinto) {
        this.laberinto = laberinto;
    }

    /**
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        int size = 34;

        super.paintComponents(g);
        int indiceImg = 0;
        if (isTodosPremios() != true) {
            arregloImagenes[2] = new ImageIcon("./src/main/resources/pisoo.png");
        } else {
            arregloImagenes[2] = new ImageIcon("./src/main/resources/muroo.png");
        }
        for (var y = 0; y < laberinto.getLimites().length; y++) {
            for (int x = 0; x < laberinto.getLimites()[y].length; x++) {
                indiceImg = laberinto.getLimites()[y][x];
                g.drawImage(arregloImagenes[indiceImg].getImage(), x * size, y * size, size, size, this);

            }
        }

        g.drawImage(getProtagonista().getProta().getImage(), getProtagonista().getX() * size, getProtagonista().getY() * size, this);
        g.drawImage(enemigos.get(1).getEnemigo().getImage(), enemigos.get(1).getPosX() * size, enemigos.get(1).getPosY() * size, this);
        g.drawImage(enemigos.get(0).getEnemigo().getImage(), enemigos.get(0).getPosX() * size, enemigos.get(0).getPosY() * size, this);

        int x, y;
        for (int i = 0; i < enemigos.size(); i++) {

            if (protagonista.getX() == enemigos.get(i).getPosX() && protagonista.getY() == enemigos.get(i).getPosY()) {
                getProtagonista().perderVida();

                setTxt("!Recibiste daño¡");

                reiniciar();

                System.out.println("Vidas: " + personajes.getProtagonista().getVida());
            }

        }
        for (int j = 0; j < corazones.size(); j++) {
            x = corazones.get(j).getPosX();
            y = corazones.get(j).getPosY();
            g.drawImage(corazones.get(j).getCorazon().getImage(), x, y, this);

            for (Corazones corazon : corazones) {
                if (getProtagonista().getVida() <= j) {
                    this.corazones.remove(j);

                }

            }

        }

        for (int i = 0; i < premios.size(); i++) {
            x = premios.get(i).getX();
            y = premios.get(i).getY();
            g.drawImage(premios.get(i).getPremio().getImage(), x * size, y * size, this);

            for (Premio premios : premios) {

                if (!premios.isRecolectado() && protagonista.getX() == premios.getX() && protagonista.getY() == premios.getY()) {
                    premios.recolectar();
                    premiosObtenidos++;
                    setTxt("Conseguiste una pelicula \n\n");

                    this.premios.remove(premios);

                }
            }

            if (premiosObtenidos == 1) {
                g.drawImage(premios.get(i).getPremio().getImage(), 858, 200, this);

            }
            if (premiosObtenidos == 2) {
                g.drawImage(premios.get(i).getPremio().getImage(), 858, 200, this);
                g.drawImage(premios.get(i).getPremio().getImage(), 918, 200, this);

            }

        }

        if (premiosObtenidos == 3) {

            setTxt("Tienes todas las peliculas");

            g.drawImage(personajes.getPremio().getPremio().getImage(), 858, 200, this);
            g.drawImage(personajes.getPremio().getPremio().getImage(), 918, 200, this);
            g.drawImage(personajes.getPremio().getPremio().getImage(), 973, 200, this);
            setTodosPremios(true);

        }

    }

    public void reiniciar() {

        setTxt("Perdiste Una Vida");
        getProtagonista().setX(2);
        getProtagonista().setY(3);
        repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
        while (hilo != null) {
            try {
                reEscribir();
                repaint();
                hilo.sleep(100);

            } catch (InterruptedException ex) {
                Logger.getLogger(Laberinto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void iniciarHilo() {
        hilo.start();

    }

    public void reEscribir() {
        for (int i = 0; i < enemigos.size(); i++) {
            enemigos.get(i).moverEnemigo();

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

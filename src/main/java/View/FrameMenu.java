/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.event.ActionListener;

/**
 *
 * @author Ricardo
 */
public class FrameMenu extends javax.swing.JFrame {

    private FrameHistoria frameHistoria;
    private FrameLaberinto frameLaberinto;
    private FrameInstrucciones frameInstrucciones;

    /**
     * Creates new form FrameMenu
     */
    public FrameMenu()  {
        initComponents();
        
        frameHistoria = new FrameHistoria();
        frameLaberinto = new FrameLaberinto();
        frameInstrucciones = new FrameInstrucciones();
    }

    public void setFrameHistoria(FrameHistoria frameHistoria) {
        this.frameHistoria = frameHistoria;
    }

    public void setFrameLaberinto(FrameLaberinto frameLaberinto) {
        this.frameLaberinto = frameLaberinto;
    }

    public void setFrameInstrucciones(FrameInstrucciones frameInstrucciones) {
        this.frameInstrucciones = frameInstrucciones;
    }
    
    

    public FrameLaberinto getFramelaberinto() {
        return this.frameLaberinto;
    }
    
    
    public FrameInstrucciones instruccionesPanel (){
        return this.frameInstrucciones;
    }
    
    public FrameHistoria historiaPanel (){
        return this.frameHistoria;
    }
    
    public void listenerButton (ActionListener listener){
        this.playButton.addActionListener(listener);
        this.historiaButton.addActionListener(listener);
        this.instruccionesButton.addActionListener(listener);
        this.salirButton.addActionListener(listener);
        this.historiaPanel().listenerButton(listener);
        this.instruccionesPanel().listenerButton(listener);
        this.getFramelaberinto().listenerButton(listener);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        historiaButton = new javax.swing.JButton();
        playButton = new javax.swing.JButton();
        instruccionesButton = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(976, 976));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        historiaButton.setBackground(new java.awt.Color(0, 51, 153));
        historiaButton.setForeground(new java.awt.Color(255, 255, 255));
        historiaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/g323.png"))); // NOI18N
        historiaButton.setActionCommand("Historia");
        historiaButton.setBorderPainted(false);
        historiaButton.setContentAreaFilled(false);
        getContentPane().add(historiaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 530, 160, 100));

        playButton.setBackground(new java.awt.Color(0, 51, 153));
        playButton.setForeground(new java.awt.Color(255, 255, 255));
        playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/g321.png"))); // NOI18N
        playButton.setActionCommand("Play");
        playButton.setBorderPainted(false);
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        getContentPane().add(playButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 270, 160, 110));

        instruccionesButton.setBackground(new java.awt.Color(0, 0, 153));
        instruccionesButton.setForeground(new java.awt.Color(255, 255, 255));
        instruccionesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/g322.png"))); // NOI18N
        instruccionesButton.setActionCommand("Instrucciones");
        instruccionesButton.setBorderPainted(false);
        instruccionesButton.setContentAreaFilled(false);
        instruccionesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instruccionesButtonActionPerformed(evt);
            }
        });
        getContentPane().add(instruccionesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(566, 401, 150, 110));

        salirButton.setBackground(new java.awt.Color(0, 51, 153));
        salirButton.setForeground(new java.awt.Color(255, 255, 255));
        salirButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/g324.png"))); // NOI18N
        salirButton.setActionCommand("Salir");
        salirButton.setBorderPainted(false);
        salirButton.setContentAreaFilled(false);
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });
        getContentPane().add(salirButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 660, 170, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playButtonActionPerformed

    private void instruccionesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instruccionesButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_instruccionesButtonActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salirButtonActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton historiaButton;
    private javax.swing.JButton instruccionesButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton playButton;
    private javax.swing.JButton salirButton;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicPaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author lucypher
 */
public class Lienzo extends javax.swing.JPanel {

    private Herramientas herramientaSeleccionada;
    private boolean relleno;
    Color color = Color.BLACK;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isRelleno() {
        return relleno;
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    public Herramientas getHerramientaSeleccionada() {
        return herramientaSeleccionada;
    }

    public void setHerramientaSeleccionada(Herramientas herr) {
        herramientaSeleccionada = herr;
    }

    public Lienzo() {
        initComponents();
    }


    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(color);
        if(herramientaSeleccionada==Herramientas.Lapiz) {
            g.fillOval(punto.x,punto.y,7,7);
        }
        if(herramientaSeleccionada == Herramientas.Linea) {
            g.drawLine(punto_pressed.x, punto_pressed.y, punto.x, punto.y);
        }
        if(herramientaSeleccionada == Herramientas.Circulo) {
            int x=0,y=0,ancho=0,alto=0;
            x = Math.min(punto_pressed.x, punto.x);
            y = Math.min(punto_pressed.y, punto.y);
            ancho = Math.abs(punto_pressed.y-punto.y);
            alto = Math.abs(punto_pressed.x-punto.x);
            if(!relleno)
                g.drawOval(x, y, alto, ancho);
            else
                g.fillOval(x, y, alto, ancho);
        }
        if(herramientaSeleccionada == Herramientas.Cuadrado) {
            int x=0,y=0,ancho=0,alto=0;
            x = Math.min(punto_pressed.x, punto.x);
            y = Math.min(punto_pressed.y, punto.y);
            ancho = Math.abs(punto_pressed.y-punto.y);
            alto = Math.abs(punto_pressed.x-punto.x);
            if(!relleno)
                g.drawRect(x, y, alto, ancho);
            else
                g.fillRect(x, y, alto, ancho);
        }
    }

    Point punto, punto_pressed;
    int forma;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        punto = evt.getPoint();
        this.repaint();
    }//GEN-LAST:event_formMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        punto_pressed = evt.getPoint();
        this.repaint();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.punto = evt.getPoint();
        this.repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        this.punto = null; //evt.getPoint();
        this.punto_pressed = null;
        this.repaint();
    }//GEN-LAST:event_formMouseReleased
    public void Reset() {
        this.punto = null;
        this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

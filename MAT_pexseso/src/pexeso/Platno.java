/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pexeso;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author janko
 */
public class Platno extends JPanel implements PropertyChangeListener{
    HerniLogika hl;

    public Platno() {
        hl = HerniLogika.getInstance();
        hl.addPropertyChangeListener(this);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hl.clik(new Point(e.getX()/50,e.getY()/50));
                repaint();
            }
            
        });
        
    }
    
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        vykresliKarty(g);
        
    }
    
    public void vykresliKarty(Graphics g){
        for (Policko pole : hl.poleKaret) {
            if (pole.otocena) {
                g.setColor(pole.barva);
                g.fillRect(pole.pozice.x*50, pole.pozice.y*50, 50, 50);
                g.setColor(Color.black);
                g.drawRect(pole.pozice.x*50, pole.pozice.y*50, 50, 50);
            }else{
                g.setColor(Color.green);
                g.fillRect(pole.pozice.x*50, pole.pozice.y*50, 50, 50);
                g.setColor(Color.black);
                g.drawRect(pole.pozice.x*50, pole.pozice.y*50, 50, 50);
            }
            
        }

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName() == "repaint") {
            repaint();
        }
    }
  
}

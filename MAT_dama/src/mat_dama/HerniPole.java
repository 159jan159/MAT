/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mat_dama;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class HerniPole extends JPanel{
    
    private int velikostPole = 50;
    private int pocetPoli = 8;
    
    Logika l;
    

    Figura f ;

    public HerniPole() {        
       this.setSize(velikostPole*pocetPoli, velikostPole*pocetPoli);
       l = new Logika();
       this.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               l.kliknuti(new Point(e.getX()/velikostPole,e.getY()/velikostPole));
               repaint();
           }
           
       });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        vykresliSachovnici(g);
        l.vykresliVse(g);
        
    }
    
    private void vykresliSachovnici(Graphics g){
        for (int i = 0; i < pocetPoli; i++) {
            for (int j = 0; j < pocetPoli; j++) {
                if(i%2 + j%2 == 1){
                    g.setColor(Color.BLACK);
                }else{
                    g.setColor(Color.WHITE);
                } 
                g.fillRect(i*velikostPole,j*velikostPole, velikostPole , velikostPole);
            }
        }
        g.setColor(Color.black);
        g.drawRect(0, 0, pocetPoli*velikostPole-1, pocetPoli*velikostPole-1);
    }    
}

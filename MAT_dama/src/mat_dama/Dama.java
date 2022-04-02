/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mat_dama;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author janko
 */
public class Dama extends figuraAbst{
    
    public Dama(Point pozice, Color barva) {
        super(pozice, barva);
    }

    public void vykresliSe(Graphics g){
        g.setColor(barva);
        g.fillOval(pozice.x*50 +5,pozice.y*50+5,40,40);
        g.setColor(Color.BLACK);
        g.drawArc(pozice.x*50+5, pozice.y*50+5, 40, 40, 0, 360);
        g.setColor(Color.red);
        g.fillOval(pozice.x*50 +12,pozice.y*50+12,25,25);
    }
}

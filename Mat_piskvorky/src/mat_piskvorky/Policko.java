package mat_piskvorky;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author janko
 */
public class Policko {
    Point pozice;
    char znak = ' ';

    public Policko(Point pozice) {
        this.pozice = pozice;
    }
    
    
    
    public void vykresliSe(Graphics g, int velikost){
        g.setColor(Color.black);
        g.drawRect(pozice.x*velikost, pozice.y*velikost, velikost, velikost);
        g.drawString(String.valueOf(znak),pozice.x*velikost+7 , pozice.y*velikost+15);
        
    }
           
}

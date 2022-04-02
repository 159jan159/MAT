package mat_dama;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author janko
 */
public abstract class figuraAbst {
    Point pozice;
    Color barva;

    public figuraAbst(Point pozice, Color barva) {
        this.pozice = pozice;
        this.barva = barva;
    }
    
    

    public Point getPozice() {
        return pozice;
    }

    public void setPozice(Point pozice) {
        this.pozice = pozice;
    }

    public Color getBarva() {
        return barva;
    }

    public void setBarva(Color barva) {
        this.barva = barva;
    }
    
    
}
    

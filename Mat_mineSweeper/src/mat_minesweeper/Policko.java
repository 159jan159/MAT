package mat_minesweeper;

import java.awt.Point;

public class Policko {
    int hodnota;
    boolean mine;
    boolean odhaleno;
    boolean oznaceno;
    Point pozice;
    
    public Policko(Point pozice){
        this.pozice = pozice;
        this.mine = false;
        this.odhaleno = false;
        this.oznaceno = false;
    }
    
    public int getHodnota() {
        return hodnota;
    }
    public void setHodnota(int hodnota) {
        this.hodnota = hodnota;
    }
    public boolean isMine() {
        return mine;
    }
    public void setMine(boolean mine) {
        this.mine = mine;
    }
    public boolean isOdhaleno() {
        return odhaleno;
    }
    public void setOdhaleno(boolean odhaleno) {
        this.odhaleno = odhaleno;
    }
    public boolean isOznaceno() {
        return oznaceno;
    }
    public void setOznaceno(boolean oznaceno) {
        this.oznaceno = oznaceno;
    }
    public Point getPozice() {
        return pozice;
    }
    public void setPozice(Point pozice) {
        this.pozice = pozice;
    }


    
}

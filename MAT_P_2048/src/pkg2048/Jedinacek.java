package pkg2048;

import java.util.ArrayList;

public class Jedinacek {
    private static Jedinacek instance = null;
    int velPlocha = 5;
    int[][] plocha = new int[velPlocha][velPlocha];
    
    
    
     public int getVelPlocha(){ 
        return velPlocha; 
    } 

    public void setVelPlocha(int velPlocha) {
        this.velPlocha = velPlocha;
    }

    public int[][] getPlocha() {
        return plocha;
    }

    public void setPlocha(int[][] plocha) {
        this.plocha = plocha;
    }



   
    
    
    public static Jedinacek getInstance() {
        if (instance == null) {
            instance = new Jedinacek(); 
        }
        return instance;
    } 
}

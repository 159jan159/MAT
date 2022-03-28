package mat_gol;

import java.util.Random;

public class model {
    
    boolean[][] pole;
   
    public model() {
        pole = new boolean[20][20];
    }
    
    public void novePole(){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                pole[i][j] = false;
            }
        }
    }
    
    public void nahodnePole(){
        Random r = new Random();
         for (int i = 0; i < 20; i++) {
             for (int j = 0; j < 20; j++) {
                 pole[i][j] = r.nextBoolean();
             }
        }
    }
    
    public void tah(){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
               int help = zkontrolujSousedy(i, j);
                if (pole[i][j] == true && help < 2) pole[i][j] = false;
                if (pole[i][j] == true && help == 2 || help == 3) pole[i][j] = true;
                if (pole[i][j] == true && help > 3) pole[i][j] = false;
                if (pole[i][j] == false && help == 3) pole[i][j] = true;
            }
        }
        
    }
    
    private int zkontrolujSousedy(int i, int j){
    int pocetSousedu = 0;
        if (i!=0 && pole[i-1][j]) pocetSousedu++;
        if (i!=19 && pole[i+1][j]) pocetSousedu++;
        
        if (i!=0&&j!=19 && pole[i-1][j+1]) pocetSousedu++;
        if (j!=19 && pole[i][j+1]) pocetSousedu++;
        if (i!=19&&j!=19 && pole[i+1][j+1]) pocetSousedu++;
        
        if (i!=0&&j!=0 && pole[i-1][j-1]) pocetSousedu++;
        if (j!=0 && pole[i][j-1]) pocetSousedu++;
        if (i!=19&&j!=0 && pole[i+1][j-1]) pocetSousedu++;
    
        return pocetSousedu;
    
    }
}

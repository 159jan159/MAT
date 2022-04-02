package mat_dama;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
public class Logika {

    Figura poleFigur[][];
    MoznyTah mozneTahy[][];
    Dama poleDam[][];
    Figura vybranaFigura;
    Dama vybranaDama;
    Color kdoJeNaRade;
    

    public Logika() {
        poleFigur = new Figura[8][8];
        poleDam = new Dama[8][8];
        mozneTahy = new MoznyTah[8][8];
        naplnPole();
        kdoJeNaRade = Color.GRAY;
        
    }
    
    public void naplnPole(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i+j)%2==1&&i<3) {
                    poleFigur[j][i] = new Figura(new Point(j, i), Color.WHITE);
                }
                if ((i+j)%2 == 1 && i>4) {
                    poleFigur[j][i] = new Figura(new Point(j, i), Color.GRAY);
                }
                
            }
        }
    }
    public void vykresliVse(Graphics g){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (poleFigur[i][j]!=null) {
                    poleFigur[i][j].vykresliSe(g);                    
                }
                if (mozneTahy[i][j]!=null) {
                    mozneTahy[i][j].vykresliSe(g);                    
                }
                if (poleDam[i][j]!=null) {
                    poleDam[i][j].vykresliSe(g);                    
                }
            }
        }
    }
    public void kliknuti(Point pozice){
        if (poleFigur[pozice.x][pozice.y] != null) {
            if (poleFigur[pozice.x][pozice.y].barva == kdoJeNaRade) {
                System.out.print("na pozici: "+ pozice);
                System.out.println("figura " + poleFigur[pozice.x][pozice.y].barva);
                vybranaDama = null;
                vybranaFigura = poleFigur[pozice.x][pozice.y];
                mozneTahy(pozice, 0);
            }            
        }
        if (poleDam[pozice.x][pozice.y] != null) {
            if (poleDam[pozice.x][pozice.y].barva == kdoJeNaRade) {
                System.out.print("na pozici: "+ pozice);
                System.out.println("Dama " + poleDam[pozice.x][pozice.y].barva);
                vybranaFigura = null;
                vybranaDama = poleDam[pozice.x][pozice.y];
                mozneTahy(pozice, 1);
            }            
        }
        if (mozneTahy[pozice.x][pozice.y] != null && vybranaFigura != null) {
    
            poleFigur[vybranaFigura.pozice.x][vybranaFigura.pozice.y] = null;
            vybranaFigura.setPozice(pozice);
            System.out.println("klikam na: "+ pozice);
            System.out.println("bude dama? : "+ (pozice.y == 0 || pozice.y ==8));
            if (pozice.y == 0 || pozice.y == 7) {
                poleDam[pozice.x][pozice.y] = new Dama(new Point(pozice.x, pozice.y), vybranaFigura.barva);
            }else{
                poleFigur[pozice.x][pozice.y] = vybranaFigura;
            }
                
            
            
            if (mozneTahy[pozice.x][pozice.y].preskakuju != null) {
                poleFigur[mozneTahy[pozice.x][pozice.y].preskakuju.x][mozneTahy[pozice.x][pozice.y].preskakuju.y] = null;
                poleDam[mozneTahy[pozice.x][pozice.y].preskakuju.x][mozneTahy[pozice.x][pozice.y].preskakuju.y] = null;
            }
            smazMozneTahy();
            if (kdoJeNaRade == Color.WHITE) {
                this.kdoJeNaRade = Color.GRAY;
                return;
            }
            if (kdoJeNaRade == Color.GRAY){
                this.kdoJeNaRade = Color.WHITE;
                return;
            }
        }
        if (mozneTahy[pozice.x][pozice.y] != null && vybranaDama != null) {
            poleDam[vybranaDama.pozice.x][vybranaDama.pozice.y] = null;
            vybranaDama.setPozice(pozice);
            poleDam[pozice.x][pozice.y] = vybranaDama;
            if (mozneTahy[pozice.x][pozice.y].preskakuju != null) {
                poleDam[mozneTahy[pozice.x][pozice.y].preskakuju.x][mozneTahy[pozice.x][pozice.y].preskakuju.y] = null;
                poleFigur[mozneTahy[pozice.x][pozice.y].preskakuju.x][mozneTahy[pozice.x][pozice.y].preskakuju.y] = null;
            }
            smazMozneTahy();
            if (kdoJeNaRade == Color.WHITE) {
                this.kdoJeNaRade = Color.GRAY;
                return;
            }
            if (kdoJeNaRade == Color.GRAY){
                this.kdoJeNaRade = Color.WHITE;
                return;
            }
        }
    }
    public void smazMozneTahy(){
        mozneTahy = new MoznyTah[8][8];
    }
    public void mozneTahy(Point pozice, int typ){
        smazMozneTahy();
        if (typ == 0) {
            if (poleFigur[pozice.x][pozice.y].barva == Color.GRAY) {
                if (pozice.x-1 >= 0 && pozice.y-1 >= 0 && poleFigur[pozice.x-1][pozice.y-1] == null) mozneTahy[pozice.x-1][pozice.y-1] = new MoznyTah(new Point(pozice.x-1,pozice.y-1), Color.blue);
                if (pozice.x+1 < 8 && pozice.y-1 >= 0 && poleFigur[pozice.x+1][pozice.y-1] == null) mozneTahy[pozice.x+1][pozice.y-1] = new MoznyTah(new Point(pozice.x+1,pozice.y-1), Color.blue);

                if (pozice.x-2 >= 0 && pozice.y-2 >= 0 && (poleFigur[pozice.x-1][pozice.y-1] != null && poleFigur[pozice.x-1][pozice.y-1].barva == Color.WHITE && poleFigur[pozice.x-2][pozice.y-2] == null) || pozice.x-2 >= 0 && pozice.y-2 >= 0 &&(poleDam[pozice.x-1][pozice.y-1] != null && poleDam[pozice.x-1][pozice.y-1].barva == Color.WHITE && poleDam[pozice.x-2][pozice.y-2] == null)) mozneTahy[pozice.x-2][pozice.y-2] = new MoznyTah(new Point(pozice.x-2,pozice.y-2), Color.blue, new Point(pozice.x-1,pozice.y-1));
                if (pozice.x+2 < 8 && pozice.y-2 >= 0 && (poleFigur[pozice.x+1][pozice.y-1] != null && poleFigur[pozice.x+1][pozice.y-1].barva == Color.WHITE && poleFigur[pozice.x+2][pozice.y-2] == null)|| pozice.x+2 < 8 && pozice.y-2 >= 0 &&(poleDam[pozice.x+1][pozice.y-1] != null && poleDam[pozice.x+1][pozice.y-1].barva == Color.WHITE && poleDam[pozice.x+2][pozice.y-2] == null)) mozneTahy[pozice.x+2][pozice.y-2] = new MoznyTah(new Point(pozice.x+2,pozice.y-2), Color.blue, new Point(pozice.x+1,pozice.y-1));
            }
            if (poleFigur[pozice.x][pozice.y].barva == Color.WHITE) {
                if (pozice.x-1 >= 0 && pozice.y+1 < 8 && poleFigur[pozice.x-1][pozice.y+1] == null) mozneTahy[pozice.x-1][pozice.y+1] = new MoznyTah(new Point(pozice.x-1,pozice.y+1), Color.blue);
                if (pozice.x+1 < 8 && pozice.y+1 < 8 && poleFigur[pozice.x+1][pozice.y+1] == null) mozneTahy[pozice.x+1][pozice.y+1] = new MoznyTah(new Point(pozice.x+1,pozice.y+1), Color.blue);

                if (pozice.x-2 >= 0 && pozice.y+2 < 8 && (poleFigur[pozice.x-1][pozice.y+1] != null && poleFigur[pozice.x-1][pozice.y+1].barva == Color.GRAY && poleFigur[pozice.x-2][pozice.y+2] == null) || pozice.x-2 >= 0 && pozice.y+2 < 8 &&(poleDam[pozice.x-1][pozice.y+1] != null && poleDam[pozice.x-1][pozice.y+1].barva == Color.GRAY && poleDam[pozice.x-2][pozice.y+2] == null)) mozneTahy[pozice.x-2][pozice.y+2] = new MoznyTah(new Point(pozice.x-2,pozice.y+2), Color.blue, new Point(pozice.x-1,pozice.y+1));
                if (pozice.x+2 < 8 && pozice.y+2 < 8 && (poleFigur[pozice.x+1][pozice.y+1] != null && poleFigur[pozice.x+1][pozice.y+1].barva == Color.GRAY && poleFigur[pozice.x+2][pozice.y+2] == null) || pozice.x+2 < 8 && pozice.y+2 < 8 &&(poleDam[pozice.x+1][pozice.y+1] != null && poleDam[pozice.x+1][pozice.y+1].barva == Color.GRAY && poleDam[pozice.x+2][pozice.y+2] == null)) mozneTahy[pozice.x+2][pozice.y+2] = new MoznyTah(new Point(pozice.x+2,pozice.y+2), Color.blue, new Point(pozice.x+1,pozice.y+1));
            }
        }else{
            int i = 1;
            while (pozice.x-i >= 0 && pozice.y-i >= 0){
                if (pozice.x-i-1 >= 0 && pozice.y-i-1 >= 0 &&
                        (poleFigur[pozice.x-i][pozice.y-i] != null &&
                        poleFigur[pozice.x-i-1][pozice.y-i-1] == null &&
                        poleDam[pozice.x-i-1][pozice.y-i-1] == null) ||
                        pozice.x-i-1 >= 0 && pozice.y-i-1 >= 0 &&
                        (poleDam[pozice.x-i][pozice.y-i] != null &&
                        poleDam[pozice.x-i-1][pozice.y-i-1] == null &&
                        poleFigur[pozice.x-i-1][pozice.y-i-1] == null)) {
                    mozneTahy[pozice.x-i-1][pozice.y-i-1] = new MoznyTah(new Point(pozice.x-i-1, pozice.y-i-1), Color.blue, new Point(pozice.x-i, pozice.y-i));
                    break;
                }               
                if (poleFigur[pozice.x-i][pozice.y-i] == null && poleDam[pozice.x-i][pozice.y-i] == null) {
                    mozneTahy[pozice.x-i][pozice.y-i] = new MoznyTah(new Point(pozice.x-i,pozice.y-i), Color.blue);
                }                
                i++;
            }
            
            i = 1;
            while (pozice.x+i < 8 && pozice.y-i >= 0){
                if (pozice.x+i+1 < 8 && pozice.y-i-1 >= 0 && poleFigur[pozice.x+i][pozice.y-i] != null && poleFigur[pozice.x+i+1][pozice.y-i-1] == null && poleDam[pozice.x+i+1][pozice.y-i-1] == null || poleDam[pozice.x+i][pozice.y-i] != null && poleFigur[pozice.x+i+1][pozice.y-i-1] == null && poleDam[pozice.x+i+1][pozice.y-i-1] == null) {
                    mozneTahy[pozice.x+i+1][pozice.y-i-1] = new MoznyTah(new Point(pozice.x+i+1, pozice.y-i-1), Color.blue, new Point(pozice.x+i, pozice.y-i));
                    break;
                }               
                if (poleFigur[pozice.x+i][pozice.y-i] == null && poleDam[pozice.x+i][pozice.y-i] == null) {
                    mozneTahy[pozice.x+i][pozice.y-i] = new MoznyTah(new Point(pozice.x+i,pozice.y-i), Color.blue);
                }                
                i++;
            }
            
            i = 1;
            while (pozice.x-i >= 0 && pozice.y+i < 8){
                if (pozice.x-i-1 >= 0 && pozice.y+i+1 <8 && poleFigur[pozice.x-i][pozice.y+i] != null && poleFigur[pozice.x-i-1][pozice.y+i+1] == null && poleDam[pozice.x-i-1][pozice.y+i+1] == null || poleDam[pozice.x-i][pozice.y+i] != null && poleFigur[pozice.x-i-1][pozice.y+i+1] == null && poleDam[pozice.x-i-1][pozice.y+i+1] == null) {
                    mozneTahy[pozice.x-i-1][pozice.y+i+1] = new MoznyTah(new Point(pozice.x-i-1, pozice.y+i+1), Color.blue, new Point(pozice.x-i, pozice.y+i));
                    break;
                }               
                if (poleFigur[pozice.x-i][pozice.y+i] == null && poleDam[pozice.x-i][pozice.y+i] == null) {
                    mozneTahy[pozice.x-i][pozice.y+i] = new MoznyTah(new Point(pozice.x-i,pozice.y+i), Color.blue);
                }                
                i++;
            }
            
            i = 1;
            while (pozice.x+i < 8 && pozice.y+i < 8){
                if (pozice.x+i+1 < 8 && pozice.y+i+1 <8 && poleFigur[pozice.x+i][pozice.y+i] != null && poleFigur[pozice.x+i+1][pozice.y+i+1] == null && poleDam[pozice.x+i+1][pozice.y+i+1] == null || poleDam[pozice.x+i][pozice.y+i] != null && poleFigur[pozice.x+i+1][pozice.y+i+1] == null && poleDam[pozice.x+i+1][pozice.y+i+1] == null) {
                    mozneTahy[pozice.x+i+1][pozice.y+i+1] = new MoznyTah(new Point(pozice.x+i+1, pozice.y+i+1), Color.blue, new Point(pozice.x+i, pozice.y+i));
                    break;
                }               
                if (poleFigur[pozice.x+i][pozice.y+i] == null && poleDam[pozice.x+i][pozice.y+i] == null) {
                    mozneTahy[pozice.x+i][pozice.y+i] = new MoznyTah(new Point(pozice.x+i,pozice.y+i), Color.blue);
                }                
                i++;
            }
        }
        
        
    }
    
    
    
}

package mat_minesweeper;

import java.awt.Point;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Random;

public class HerniLogika {
    int velikostPole;
    int velikostHernihoPole;
    int pocetMin;
    
    Policko[][] policka;
    
    boolean vytvoreno;
    
    private static HerniLogika single_instance = null;
    
    public HerniLogika(){
        this.velikostPole = 12;
        this.velikostHernihoPole = 12;
        this.pocetMin = 5;    
        this.vytvoreno = false;
        vytvorPole();
        
    }
    
    public static HerniLogika getInstance()
    {
        if (single_instance == null)
            single_instance = new HerniLogika();
 
        return single_instance;
    }
    
    public void vytvorPole(){
        vytvoreno = false;
        this.pocetMin = 5;
        policka = new Policko[velikostHernihoPole][velikostHernihoPole];
        for (int i = 0; i < velikostHernihoPole; i++) {
            for (int j = 0; j < velikostHernihoPole; j++) {
                policka[i][j] = new Policko(new Point(i, j));
            }
        }
    }
    public void vytvorHru(Point prvniKlik){
        Random random = new Random();
        vytvoreno = true;
        while(pocetMin>0){
            Point nahoda = new Point(random.nextInt(policka.length), random.nextInt(policka.length));
            if (!policka[nahoda.x][nahoda.y].mine) {
                if (nahoda != prvniKlik) {                   
                
                    policka[nahoda.x][nahoda.y].mine = true;

                    if (nahoda.x+1<velikostHernihoPole)policka[nahoda.x+1][nahoda.y].hodnota++;
                    if (nahoda.x-1>=0)policka[nahoda.x-1][nahoda.y].hodnota++;                
                    if (nahoda.y+1<velikostHernihoPole)policka[nahoda.x][nahoda.y+1].hodnota++;
                    if (nahoda.y-1>=0)policka[nahoda.x][nahoda.y-1].hodnota++;

                    if (nahoda.x+1<velikostHernihoPole&&nahoda.y+1<velikostHernihoPole)policka[nahoda.x+1][nahoda.y+1].hodnota++;
                    if (nahoda.x+1<velikostHernihoPole&&nahoda.y-1>=0)policka[nahoda.x+1][nahoda.y-1].hodnota++;
                    if (nahoda.x-1>=0&&nahoda.y+1<velikostHernihoPole)policka[nahoda.x-1][nahoda.y+1].hodnota++;
                    if (nahoda.x-1>=0&&nahoda.y-1>=0)policka[nahoda.x-1][nahoda.y-1].hodnota++;
                    pocetMin--;
                }
            }
            
        }
    }
    
    public void odhal(Point Poz_Klik){
        if (policka[Poz_Klik.x][Poz_Klik.y].mine) {
            propertyChangeSupport.firePropertyChange("prohra", 1, 0);
            return;
        }
        policka[Poz_Klik.x][Poz_Klik.y].odhaleno = true;        
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (Poz_Klik.x+i <0)continue;
                if (Poz_Klik.y+j <0)continue;
                if (Poz_Klik.x+i >= velikostHernihoPole)continue;
                if (Poz_Klik.y+j >= velikostHernihoPole)continue;
                if (policka[Poz_Klik.x+i][Poz_Klik.y+j].mine) continue;
                if (policka[Poz_Klik.x+i][Poz_Klik.y+j].odhaleno)continue;
                if (policka[Poz_Klik.x][Poz_Klik.y].hodnota == 0){
                    odhal(new Point(Poz_Klik.x+i, Poz_Klik.y+j));
                }
            }
        }
        kontrola();
    }
    
    public void kontrola(){
        for (int i = 0; i < velikostHernihoPole; i++) {
            for (int j = 0; j < velikostHernihoPole; j++) {
                if (!policka[i][j].mine) {
                    if (!policka[i][j].odhaleno) {
                        return;
                    }                    
                }
            }
        }
        propertyChangeSupport.firePropertyChange("vyhra", 1, 2);
    }
    
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }


    
    
    public void vpis(){
        for (int i = 0; i < velikostHernihoPole; i++) {
            for (int j = 0; j < velikostHernihoPole; j++) {
                if (policka[i][j].mine) {
                    System.out.print("X");
                }else{
                    System.out.print(policka[i][j].hodnota);
                }                
            }
            System.out.println("");
        }
    }
}

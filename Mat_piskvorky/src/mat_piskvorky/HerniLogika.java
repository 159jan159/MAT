package mat_piskvorky;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author janko
 */
public class HerniLogika {
    private static HerniLogika single_instance = null;
    
    public int vyskaPole;
    public int sirkaPole;
    
    public String jmenoP1;
    public String jmenoP2;
    
    public char p1;
    public char p2;
    
    public boolean rada;
    
    public Policko[][] herniPole;

    public HerniLogika() {
        this.vyskaPole = 10;
        this.sirkaPole = 10;
        this.jmenoP1 = "Player-1";
        this.jmenoP2 = "Player-2";
        this.p1 = 'X';
        this.p2 = 'O';
        this.rada = true;
        novaHra();
    }
    
    
    
    public void novaHra(){
        herniPole = new Policko[vyskaPole][sirkaPole];
        this.rada = true;
        for (int i = 0; i < vyskaPole; i++) {
            for (int j = 0; j < sirkaPole; j++) {
                herniPole[i][j] = new Policko(new Point(i,j));
            }
        }
    }
    
    public void klik(MouseEvent e){
        if (herniPole[e.getX()/20][e.getY()/20].znak != ' ')return;
        
        if (rada) {
            herniPole[e.getX()/20][e.getY()/20].znak = p1;
            rada = false;
        }else{
            herniPole[e.getX()/20][e.getY()/20].znak = p2;
            rada = true;
        } 
        if (kontrolaVyhry(new Point(e.getX()/20, e.getY()/20))){
            if (rada) {
                propertyChangeSupport.firePropertyChange("vyhra", jmenoP2, 0);
            }else{
                propertyChangeSupport.firePropertyChange("vyhra", jmenoP1, 0);
            }
        }
    }  
    
    public boolean kontrolaVyhry(Point pozice){
        int i = 1;
        int j = 1;
        int pocet = 1;
        
        while(pozice.x+i < sirkaPole && herniPole[pozice.x][pozice.y].znak == herniPole[pozice.x+i][pozice.y].znak){    
            i++;
            pocet++;
            if (pocet >= 5) return true;
        }       
        i = 1;
        while(pozice.x-i > 0 && herniPole[pozice.x][pozice.y].znak == herniPole[pozice.x-i][pozice.y].znak){    
            i++;
            pocet++;
            if (pocet >= 5) return true;
        }
        i = 1;
        pocet = 1;
        while(pozice.y+i < vyskaPole && herniPole[pozice.x][pozice.y].znak == herniPole[pozice.x][pozice.y+i].znak){    
            i++;
            pocet++;
            if (pocet >= 5) return true;
        }
        i = 1;
        while(pozice.y-i > 0 && herniPole[pozice.x][pozice.y].znak == herniPole[pozice.x][pozice.y-i].znak){    
            i++;
            pocet++;
            if (pocet >= 5) return true;
        }
        i = 1;
        pocet = 1;
        while(pozice.x+i < sirkaPole && pozice.y+j < vyskaPole && herniPole[pozice.x][pozice.y].znak == herniPole[pozice.x+i][pozice.y+j].znak){    
            i++;
            j++;
            pocet++;
            if (pocet >= 5) return true;
        }
        i = 1;
        j = 1;
        while(pozice.x-i > 0 && pozice.y-j > 0 && herniPole[pozice.x][pozice.y].znak == herniPole[pozice.x-i][pozice.y-i].znak){    
            i++;
            j++;
            pocet++;
            if (pocet >= 5) return true;
        }
        i = 1;
        j = 1;
        pocet = 1;
        while(pozice.x+i < sirkaPole && pozice.y-j > 0 && herniPole[pozice.x][pozice.y].znak == herniPole[pozice.x+i][pozice.y-i].znak){    
            i++;
            j++;
            pocet++;
            if (pocet >= 5) return true;
        }
        i = 1;
        j = 1;
        while(pozice.x-i > 0 && pozice.y+j < vyskaPole && herniPole[pozice.x][pozice.y].znak == herniPole[pozice.x-i][pozice.y+i].znak){    
            i++;
            j++;
            if (pocet >= 5) return true;
        }
return false;
    }
    
    //Singleton
    public static HerniLogika getInstance(){
        if(single_instance == null){
            single_instance = new HerniLogika();
        }
        return single_instance;
    }
    
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }   
    
}

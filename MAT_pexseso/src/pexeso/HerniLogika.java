/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pexeso;

import java.awt.Color;
import java.awt.Point;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class HerniLogika {
    ArrayList<Hrac> Hraci = new ArrayList<>();
    int pocetDvojic;
    
    ArrayList<Policko> poleKaret = new ArrayList<>();
    
    int pocetOtoceni;
    int kdoJeNaRade;
    
    private static HerniLogika single_instance = null;

    public HerniLogika() {
        pocetDvojic = 9;
        vytvorHrace("Pepíno");
        vytvorHrace("Jirkos");
    }   
    
    //Singleton
    public static HerniLogika getInstance(){
        if(single_instance == null){
            single_instance = new HerniLogika();
        }
        return single_instance;
    }
    
    public void novaHra(){
        int pocetVRadku = (int) Math.round(Math.pow(pocetDvojic*2, (1.0/2.0)));
        int pocetVSloupci = (int) (pocetDvojic*2)/pocetVRadku;    
        int posledniRadek = (pocetDvojic*2)-(pocetVRadku*pocetVSloupci);
        ArrayList<Color> barvy = new ArrayList<>(vytvorBarvy(pocetDvojic));
        Collections.shuffle(barvy);
        for (int i = 0; i < pocetVSloupci; i++) {
            for (int j = 0; j < pocetVRadku; j++) {
                poleKaret.add(new Policko(new Point(i, j)));
            }
        }
        for (int i = 0; i < posledniRadek; i++) {
            poleKaret.add(new Policko(new Point(i, pocetVSloupci)));
        }
        for (int i = 0; i < poleKaret.size(); i++) {
            poleKaret.get(i).barva = barvy.get(i);
        }
                
    }
    
    public void clik(Point pozice){
        System.out.println("na rade je" + kdoJeNaRade);
        for (Policko pole : poleKaret) {
            if (pole.pozice.equals(pozice)&&!pole.otocena){
                pole.otocena = true;
                pocetOtoceni++;
            }
            
        }                      
        if (pocetOtoceni == 2) {
            kontrola();
        }
    }
    
    public void kontrola(){
        ArrayList<Policko> help = new ArrayList<>();
        pocetOtoceni = 0;
        for (Policko pole : poleKaret) {
            if (pole.otocena) {
                help.add(pole);
            }
        }
        if (help.get(0).barva == help.get(1).barva) {
            Hraci.get(kdoJeNaRade).score++;
        }else{
            if (kdoJeNaRade==Hraci.size()-1) {
                kdoJeNaRade = 0;
            }else{
                kdoJeNaRade++;
            }
            Timer t = new Timer("Timer");
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("run");
                    for (Policko pole : poleKaret) {
                        if (pole.otocena) {
                            pole.otocena = false;
                        }
                    }
                    System.out.println("pal");
                    propertyChangeSupport.firePropertyChange("repaint", 1, 0);
                }
            }, 1000);
            
        }
        
    }
    
    public void vytvorHrace(String jmeno){
        Hraci.add(new Hrac(jmeno));
    }
    
    public void smazHrace(){
        Hraci.clear();
    }
    
    public ArrayList<Color> vytvorBarvy(int pocet){
        ArrayList<Color> help = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < pocet*2; i++) {
            int rand = r.nextInt();
            Color barva = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            help.add(barva);
            help.add(barva);
        }
        
        return help;
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}

package mat_sibenice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpravaSLov {
    private  ArrayList<String> slova;
    private String cesta;
    private File soubor;

    public SpravaSLov(){
        this.cesta = "src/slova/slova.txt";
        this.soubor = new File(cesta);
        this.slova = new ArrayList<>();
        this.slova.clear();
        try {
            nactiSlova();
        } catch (IOException ex) {
            Logger.getLogger(SpravaSLov.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public String vyberNahodneSlovo(){
        Random r = new Random();
        if (this.slova.size()>0) {
            return this.slova.get(r.nextInt(this.slova.size()));
        }else{
            return null;
        }
        
    }
    
    //Nacti Slova
    private void nactiSlova() throws FileNotFoundException, IOException {
        this.slova.clear();
        BufferedReader br = new BufferedReader(new FileReader(this.soubor));
            String line;
            while ((line = br.readLine()) != null) {
                this.slova.add(line);
            }
    }
    
    private void vypisPole(){
    }
    
    //Pridej Slovo
    
    //Odeber Slovo
    
    
}

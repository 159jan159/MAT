package mat_sibenice;

import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.JPanel;

public class VykresliDoplnovani extends JPanel implements PropertyChangeListener {
    
    private String slovo;
    private char[] pismenaSlova;
    
    SpravaSLov ss = new SpravaSLov();
    

    public VykresliDoplnovani(){
        super();               
        slovo = ss.vyberNahodneSlovo();
        pismenaSlova = new char[0];
        novaHra();
    }
    
    //public metody
    public void novaHra(){
        noveSlovo(ss.vyberNahodneSlovo());
        repaint();
    }
    
    
    //private metody
    private void noveSlovo(String slovo){    
        if(slovo!=null){
            slovo = slovo.toUpperCase();
            this.slovo = slovo;
            this.pismenaSlova = slovo.replaceAll("[^.!?\\s]", "_").toCharArray();
        }else{
            return;
        }
    }
    
    private boolean zkusPismeno(char pismeno){
        if(!slovo.contains(String.valueOf(pismeno))) return false;            
        for (int i = 0; i < slovo.length(); i++) {
            if (this.slovo.charAt(i)==pismeno) {
                this.pismenaSlova[i] = this.slovo.charAt(i);
                repaint();
                
            }
            
        }
        return true;
        //return false;
    }
    
    private boolean zkontrolujVyhru(){
        if(String.valueOf(this.pismenaSlova).contains(String.valueOf("_"))){
            return false;
        }else{
            return true;
        }     
    }          
    
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(new String(this.pismenaSlova), this.getWidth()/2, this.getHeight()/2);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (!"stisk_tlacitka".equals(evt.getPropertyName())) return;
        if (!zkusPismeno(evt.getNewValue().toString().charAt(0)))
            propertyChangeSupport.firePropertyChange("spatne_pismenko", "", "a");
        if (zkontrolujVyhru())
            propertyChangeSupport.firePropertyChange("vyhra", "", "a");
    }
    
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
}

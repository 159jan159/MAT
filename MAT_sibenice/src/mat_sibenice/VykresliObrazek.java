package mat_sibenice;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class VykresliObrazek extends JPanel implements PropertyChangeListener{
    
    private ArrayList<BufferedImage> obrazky;
    private int soucasnyObrazek;
    
    public VykresliObrazek() throws IOException {
        this.obrazky = new ArrayList<>();
        this.naplnObrazky();
        this.novaHra();
        this.setSize(300, 300);
    }
    
   private void naplnObrazky() throws IOException{
       for (int i = 0; i < 10; i++) {
           try {
               this.obrazky.add(ImageIO.read(new File("src/obrazky/"+i+".png")));
           } catch (Exception e) {
               System.out.println("není obrázek");
           }
           
       }
   }
   
   @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(this.obrazky.isEmpty())return;
        g.drawImage(obrazky.get(soucasnyObrazek), 0, 0,300,300,this);
        
}
   
    
   public boolean vykresliDalsiObrazek(){
        if(this.obrazky.size()>this.soucasnyObrazek+1) {
            soucasnyObrazek++;
            this.repaint();
            return true;
        }else{return false;}
       
   }
   public void novaHra(){
       this.soucasnyObrazek = 0;
       this.repaint();
   }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("spatne_pismenko")){
            if (!vykresliDalsiObrazek()) {
                propertyChangeSupport.firePropertyChange("prohra", "", "a");
            }
        }
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

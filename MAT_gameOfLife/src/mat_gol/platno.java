package mat_gol;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class platno extends JPanel{
    model model = new model();
    int width = 20; 
    boolean editable = false;
    Timer timer;
            
    public platno() {
        super();
        this.setBackground(Color.BLACK);
        this.setSize(width*20+3, width*20+3);
        model.novePole();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (editable) {
                    model.pole[e.getX()/width][e.getY()/width] = !model.pole[e.getX()/width][e.getY()/width];
                    repaint();
                }
            }
            
        });
        timer = new Timer(50, (e) -> {
            model.tah();
            this.repaint();
        });
      }    
    
    public void nahodnePole(){
        model.nahodnePole();
        repaint();
    }
    
    public void cistePole(){
        model.novePole();
        repaint();
    }
    
    public void start(){
        if (!timer.isRunning()) {
            timer.start();
        }
    }
    
    public void stop(){
        timer.stop();
    }
    
    public void vykresliPole(Graphics g){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (model.pole[i][j]) {
                    g.setColor(Color.BLACK);
                }else{
                    g.setColor(Color.WHITE);
                }
                g.fillRect(i*width+1, j*width+1, width, width);
                g.setColor(Color.BLACK);
                g.drawRect(i*width+1, j*width+1, width, width);
            }
        }
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        vykresliPole(g);
    }
    
}

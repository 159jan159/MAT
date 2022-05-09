package pkg2048;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Platno extends JPanel implements KeyListener, ActionListener{
    Timer t;
    Font bigFont;
    int velFont, velKostka = 10;
    Jedinacek jed;
    Hra hra;
    int[][] plocha;
    int velP = 0;
     public Platno(){
        super();
        jed = Jedinacek.getInstance();
        hra = new Hra();
        velP = jed.getVelPlocha();
        plocha = jed.getPlocha();
        this.setFocusable(true);
         addKeyListener(this);
        this.setBackground(Color.BLACK);
        this.setSize(500, 500);
        velKostka = Math.round(500/jed.getVelPlocha());
        velFont = velKostka/3;
        bigFont = new Font("Serif", Font.BOLD, velFont);
        
         t = new Timer(16, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    });
         t.start();
    }
     public void move(int kam){
         hra.move(kam);
         this.plocha = jed.getPlocha();
     }
     public Color barveni(int cislo){
         //g nejvetsi maly, r vetsi vetsi        
         int r = 50-(cislo*2) ;
         int g = 70+cislo*4;
         int b = 50;
         if(r<0){r=255;}
         if(g>255){g=0;}
         Color c = new Color(r, g, b);
         return c;
     }
     
     @Override
     public void paintComponent(Graphics g){
         super.paintComponent(g);
         Color c;
            for (int i = 0; i < plocha.length; i++) {
                for (int j = 0; j < plocha.length; j++) {
                    int hodnota = plocha[i][j];
                       if(hodnota != 0){
                            c = barveni(hodnota);
                            g.setColor(c);
                       }else{
                           g.setColor(Color.darkGray);
                       }
                    g.fillRect(i*velKostka+i, j*velKostka+j, velKostka, velKostka);
                    if(hodnota != 0){
                            g.setFont(bigFont);
                            g.setColor(Color.WHITE);
                            g.drawString(String.valueOf(hodnota), (i*velKostka)+(velKostka/2), (j*velKostka)+((velKostka/2)));
                    }
                 }
            }
     }

     
     
     //Čudl inputs
    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                move(0);
                break;
            case KeyEvent.VK_UP:
                move(0);
                break;
           case KeyEvent.VK_S:
                move(1);
                break;
            case KeyEvent.VK_DOWN:
                move(1);
                break;
            case KeyEvent.VK_A:
                move(2);
                break;
            case KeyEvent.VK_LEFT:
                move(2);
                break;
            case KeyEvent.VK_D:
                move(3);
                break;
            case KeyEvent.VK_RIGHT:
                move(3);
                break;
                
        }
            
    }

    @Override
    public void keyReleased(KeyEvent e) {
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   
    }
     
}

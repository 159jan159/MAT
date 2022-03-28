package mat_minesweeper;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.text.html.HTML;

/**
 *
 * @author janko
 */
public class Platno extends JPanel{

    HerniLogika HL;
    
    public Platno() {
        HL = HerniLogika.getInstance();
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if (!HL.vytvoreno) {
                    HL.vytvorHru(new Point(e.getX()/35,e.getY()/35));
                }
                if (e.getButton() == 1 && !HL.policka[e.getX()/35][e.getY()/35].oznaceno) {
                    HL.odhal(new Point(e.getX()/35,e.getY()/35));
                    repaint();
                }
                if (e.getButton() == 3 && !HL.policka[e.getX()/35][e.getY()/35].odhaleno) {
                    HL.policka[e.getX()/35][e.getY()/35].oznaceno = !HL.policka[e.getX()/35][e.getY()/35].oznaceno;
                    repaint();
                }            
                repaint();
            }
        });
        this.setSize(HL.velikostHernihoPole*35+1, HL.velikostHernihoPole*35+1);
    }
    
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        vykresliSe(g);
        
    }
    
    public void vykresliSe(Graphics g){
        g.setFont(new Font("Arial",1,25));
        for (int i = 0; i < HL.velikostHernihoPole; i++) {
            for (int j = 0; j < HL.velikostHernihoPole; j++) {
                if (HL.policka[i][j].odhaleno) {
                    if (HL.policka[i][j].mine) {
                        g.drawString("X", (HL.policka[i][j].pozice.x*35)+10, ((HL.policka[i][j].pozice.y+1)*35)-8);
                    }else{
                        if (HL.policka[i][j].hodnota == 0) {
                            g.setColor(Color.lightGray);
                            g.fillRect(HL.policka[i][j].pozice.x*35, HL.policka[i][j].pozice.y*35, 35, 35);
                        }else{
                            g.setColor(Color.lightGray);
                            g.fillRect(HL.policka[i][j].pozice.x*35, HL.policka[i][j].pozice.y*35, 35, 35);
                            g.setColor(Color.black);
                            g.drawString(String.valueOf(HL.policka[i][j].hodnota), (HL.policka[i][j].pozice.x*35)+11, ((HL.policka[i][j].pozice.y+1)*35)-8);
                        }
                        
                    }
                }
                if (HL.policka[i][j].oznaceno) {
                    g.fillOval((HL.policka[i][j].pozice.x*35)+8,((HL.policka[i][j].pozice.y)*35)+8, 20, 20);
                }
                g.setColor(Color.black);
                g.drawRect(HL.policka[i][j].pozice.x*35, HL.policka[i][j].pozice.y*35, 35, 35);
            }
        }
    }
    
}

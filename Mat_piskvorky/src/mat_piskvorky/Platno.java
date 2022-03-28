package mat_piskvorky;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;

/**
 *
 * @author janko
 */
public class Platno extends JPanel{
    int velikostPolicka = 20;
    
    HerniLogika hl;

    public Platno() {
        hl = HerniLogika.getInstance();
        this.setPreferredSize(new Dimension(hl.vyskaPole*velikostPolicka+1, hl.sirkaPole*velikostPolicka+1));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hl.klik(e);
                repaint();
            }
        });
        
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        vykresliPole(g);
    }
    
    public void vykresliPole(Graphics g){
        for (int i = 0; i < hl.vyskaPole; i++) {
            for (int j = 0; j < hl.sirkaPole; j++) {
                hl.herniPole[i][j].vykresliSe(g, velikostPolicka);
            }
        }
    }       
    
}

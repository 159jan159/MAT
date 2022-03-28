/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulacka_3.pkg0;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
public class tlacitko extends JButton{
    //vlastnosti
    private I_algoritmus strategie;

    //konstruktor
    public tlacitko() {
    }
    public tlacitko(I_algoritmus mujAlgoritmus, String text, final int klavesa){
        nastavAlgoritmus(mujAlgoritmus);
        this.setText(text);

        ActionListener mujListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spustitAlgoritmus();
            }
    };
        this.addActionListener(mujListener);
        this.registerKeyboardAction(mujListener, KeyStroke.getKeyStroke(klavesa, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }
    //metody
    public void spustitAlgoritmus(){
        strategie.algoritmus();
    }
    public void nastavAlgoritmus(I_algoritmus alg){
        this.strategie = alg;
    }
    
    
}



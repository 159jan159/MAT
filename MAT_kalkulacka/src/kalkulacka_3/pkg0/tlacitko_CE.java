/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulacka_3.pkg0;

/**
 *
 * @author janko
 */
public class tlacitko_CE implements I_algoritmus{
    RadekModel model = RadekModel.getInstance();
    @Override
    public void algoritmus() {        
        model.setRadek2("0");
    }
    
}

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
public class tlacitko_DEL implements I_algoritmus{
    RadekModel model = RadekModel.getInstance();
    @Override
    public void algoritmus() {    
        if(model.getRadek2() != "0"){
            model.setRadek2(model.getRadek2().substring(0, model.getRadek2().length()-1));
            if(model.getRadek2() == ""){
                model.setRadek2("0");
            }
        }
    }
    
}
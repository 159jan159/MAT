package kalkulacka_3.pkg0;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class tlacitko_rovnase implements I_algoritmus{
    RadekModel model = RadekModel.getInstance();
    @Override
    public void algoritmus() {
        model.setRadek1(model.getRadek1()+model.getRadek2());
        try {
            Expression exp = new ExpressionBuilder(model.getRadek1()).build();
            model.setRadek2(Double.toString(exp.evaluate()));
            model.setRadek1("");
        } catch (Exception e) {            
            model.setRadek2("ERROR");
            model.setRadek1("");
            throw e;
        }
        
        
        

                 
    }
}
    


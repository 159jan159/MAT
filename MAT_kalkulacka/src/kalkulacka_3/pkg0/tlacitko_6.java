package kalkulacka_3.pkg0;
public class tlacitko_6 implements I_algoritmus{
    RadekModel model = RadekModel.getInstance();
    @Override
    public void algoritmus() {        
        if(model.getRadek2() == "0"){
            model.setRadek2("6");
        }else{
            model.setRadek2(model.getRadek2()+"6");
        }
    }
    
}

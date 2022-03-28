package kalkulacka_3.pkg0;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public final class RadekModel {
    
    String radek1 = "";
    String radek2 = "0";
    
    RadekModel() {
    }

    public String getRadek1() {
        return radek1;
    }

    public void setRadek1(String radek1) {
        this.radek1 = radek1;
        propertyChangeSupport.firePropertyChange("radek1", "a", this.radek1);
    }

    public String getRadek2() {
        return radek2;
    }

    public void setRadek2(String radek2) {
        this.radek2 = radek2;
        propertyChangeSupport.firePropertyChange("radek2", "a", this.radek2);
    }
    
    
    public static RadekModel getInstance() {
        return RadekModelHolder.INSTANCE;
    }
    
    private static class RadekModelHolder {

        private static final RadekModel INSTANCE = new RadekModel();
    }
    

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}


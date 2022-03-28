package kalkulacka_3.pkg0;

import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class view extends javax.swing.JFrame implements PropertyChangeListener{
    RadekModel model = RadekModel.getInstance();
    
    public view() {
        initComponents();
        model.addPropertyChangeListener(this);
        model.setRadek2("0");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        tlacitko1 = new kalkulacka_3.pkg0.tlacitko(new tlacitko_carka(),".",KeyEvent.VK_SEPARATOR);
        tlacitko13 = new kalkulacka_3.pkg0.tlacitko(new tlacitko_8(),"8",KeyEvent.VK_8);
        tlacitko2 = new kalkulacka_3.pkg0.tlacitko(new tlacitko_rovnase(),"=",KeyEvent.VK_EQUALS);
        tlacitko8 = new kalkulacka_3.pkg0.tlacitko(new tlacitko_6(),"6",KeyEvent.VK_6);
        tlacitko9 = new kalkulacka_3.pkg0.tlacitko(new tlacitko_5(),"5",KeyEvent.VK_5);
        tlacitko11 = new kalkulacka_3.pkg0.tlacitko(new tlacitko_minus(),"-",KeyEvent.VK_MINUS);
        tlacitko16 = new kalkulacka_3.pkg0.tlacitko(new tlacitko_DEL(),"<-",KeyEvent.VK_BACK_SPACE);
        tlacitko7 = new kalkulacka_3.pkg0.tlacitko(new tlacitko_3(),"3",KeyEvent.VK_3);
        tlacitko5 = new kalkulacka_3.pkg0.tlacitko(new tlacitko_1(),"1",KeyEvent.VK_1);
        tlacitko17 = new kalkulacka_3.pkg0.tlacitko(new tlacitko_CE(),"CE",KeyEvent.VK_C);
        tlacitko12 = new kalkulacka_3.pkg0.tlacitko(new tlacitko_9(),"9",KeyEvent.VK_9);
        tlacitko6 = new kalkulacka_3.pkg0.tlacitko(new tlacitko_plus(),"+",KeyEvent.VK_PLUS);
        tlacitko10 = new kalkulacka_3.pkg0.tlacitko(new tlacitko_4(),"4",KeyEvent.VK_4);
        tlacitko3 = new kalkulacka_3.pkg0.tlacitko(new tlacitko_0(),"0",KeyEvent.VK_0);
        tlacitko4 = new kalkulacka_3.pkg0.tlacitko(new tlacitko_2(),"2",KeyEvent.VK_2);
        tlacitko19 = new kalkulacka_3.pkg0.tlacitko(new tlacitko_deleno(),"/",KeyEvent.VK_DIVIDE);
        tlacitko15 = new kalkulacka_3.pkg0.tlacitko(new tlacitko_krat(),"*",KeyEvent.VK_MULTIPLY);
        tlacitko18 = new kalkulacka_3.pkg0.tlacitko(new tlacitko_C(),"C",KeyEvent.VK_DELETE);
        tlacitko14 = new kalkulacka_3.pkg0.tlacitko(new tlacitko_7(),"7",KeyEvent.VK_7);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        tlacitko1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tlacitko13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tlacitko2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tlacitko8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tlacitko9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tlacitko11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tlacitko16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tlacitko7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tlacitko5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tlacitko17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tlacitko12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tlacitko6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tlacitko10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tlacitko3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tlacitko4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tlacitko19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tlacitko15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tlacitko18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tlacitko14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tlacitko5, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                .addGap(10, 10, 10)
                                .addComponent(tlacitko4, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tlacitko3, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                .addGap(10, 10, 10)
                                .addComponent(tlacitko1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tlacitko7, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                .addGap(10, 10, 10)
                                .addComponent(tlacitko6, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                            .addComponent(tlacitko2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tlacitko10, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(tlacitko9, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tlacitko8, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(tlacitko11, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tlacitko14, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(tlacitko13, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tlacitko12, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(tlacitko15, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tlacitko18, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(tlacitko17, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tlacitko16, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(tlacitko19, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tlacitko17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tlacitko18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tlacitko19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tlacitko16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tlacitko13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tlacitko14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tlacitko15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tlacitko12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tlacitko9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tlacitko10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tlacitko11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tlacitko8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tlacitko4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tlacitko5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tlacitko6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tlacitko7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tlacitko1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tlacitko3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tlacitko2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private kalkulacka_3.pkg0.tlacitko tlacitko1;
    private kalkulacka_3.pkg0.tlacitko tlacitko10;
    private kalkulacka_3.pkg0.tlacitko tlacitko11;
    private kalkulacka_3.pkg0.tlacitko tlacitko12;
    private kalkulacka_3.pkg0.tlacitko tlacitko13;
    private kalkulacka_3.pkg0.tlacitko tlacitko14;
    private kalkulacka_3.pkg0.tlacitko tlacitko15;
    private kalkulacka_3.pkg0.tlacitko tlacitko16;
    private kalkulacka_3.pkg0.tlacitko tlacitko17;
    private kalkulacka_3.pkg0.tlacitko tlacitko18;
    private kalkulacka_3.pkg0.tlacitko tlacitko19;
    private kalkulacka_3.pkg0.tlacitko tlacitko2;
    private kalkulacka_3.pkg0.tlacitko tlacitko3;
    private kalkulacka_3.pkg0.tlacitko tlacitko4;
    private kalkulacka_3.pkg0.tlacitko tlacitko5;
    private kalkulacka_3.pkg0.tlacitko tlacitko6;
    private kalkulacka_3.pkg0.tlacitko tlacitko7;
    private kalkulacka_3.pkg0.tlacitko tlacitko8;
    private kalkulacka_3.pkg0.tlacitko tlacitko9;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName() == "radek1"){
            this.jTextField1.setText(String.valueOf(evt.getNewValue()));
        }
        if(evt.getPropertyName() == "radek2"){
            this.jTextField2.setText(String.valueOf(evt.getNewValue()));
        }
    }
    

}

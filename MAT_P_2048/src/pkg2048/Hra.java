package pkg2048;

import java.util.Random;

public class Hra {
    Jedinacek jed;
    Random r;
    int velP = 0;
    int[][] plocha;
    public Hra(){
        jed = Jedinacek.getInstance();
        r = new Random();
        velP = jed.getVelPlocha();
        plocha = jed.getPlocha();
        restart();
    }
    private void secti(int x, int y, int kam){
        
    }
    private void uka(){
    }
    public void move(int kam){
       boolean znovu = true;
       while(znovu){
          znovu = false;
       for (int i = 0; i < velP; i++) {
             for (int j = 0; j < velP; j++) {
                 if(plocha[i][j] != 0){
                    switch(kam){
                        case 0:
                             if(j!=0){
                                    if(plocha[i][j-1]==0){
                                        plocha[i][j-1] = plocha[i][j];
                                        plocha[i][j] = 0;
                                    }else if(plocha[i][j-1]==plocha[i][j]){
                                        plocha[i][j-1] = plocha[i][j]*2;
                                        plocha[i][j] = 0;
                                    }
                             }
                             //znovu check
                              if(j>1){
                                        if(plocha[i][j-2]==0 || plocha[i][j-2] == plocha[i][j-1]){
                                            znovu = true; 
                                        }
                              }
                            break;
                       case 1:
                         if(j!=velP-1){
                            if(plocha[i][j+1]==0){
                                 plocha[i][j+1] = plocha[i][j];
                                 plocha[i][j] = 0;
                             }else if(plocha[i][j+1]==plocha[i][j]){
                                 plocha[i][j+1] = plocha[i][j]*2;
                                 plocha[i][j] = 0;
                             }
                         }
                             if(j<velP-2){
                                        if(plocha[i][j+2]==0 || plocha[i][j+2] == plocha[i][j+1]){
                                            znovu = true; 
                                        }
                              }
                            break;
                       case 2:
                         if(i!=0){
                           if(plocha[i-1][j]==0){
                                plocha[i-1][j] = plocha[i][j];
                                plocha[i][j] = 0;
                            }else if(plocha[i-1][j]==plocha[i][j]){
                                plocha[i-1][j] = plocha[i][j]*2;
                                plocha[i][j] = 0;
                            }
                            
                         }
                         if(i>1){
                             if(plocha[i-2][j]==0 || plocha[i-2][j] == plocha[i-1][j]){
                                    znovu = true;
                            }
                         }
                            break;
                        case 3:
                          if(i!=velP-1){
                            if(plocha[i+1][j]==0){
                                plocha[i+1][j] = plocha[i][j];
                                plocha[i][j] = 0;
                            }else if(plocha[i+1][j]==plocha[i][j]){
                                plocha[i+1][j] = plocha[i][j]*2;
                                plocha[i][j] = 0;
                            }
                          }
                            if(i<velP-2){
                                        if(plocha[i+2][j]==0 || plocha[i+2][j] == plocha[i+1][j]){
                                            znovu = true; 
                                        }
                              }
                            break;
                    }
                 }
              }
         }
       }
         nandejNovou();
         jed.setPlocha(plocha);
    }
    
    private void restart(){
        //zandá první kostky
        for (int i = 0; i < r.nextInt(4-2)+2; i++) {
            nandejNovou();
        }
        
    }
    private void nandejNovou(){
        //Přidá novou kostku do pole
       int chance = r.nextInt(100);
       int ranX = r.nextInt(velP);
       int ranY = r.nextInt(velP);
       if(chance<80){
           if(plocha[ranX][ranY] ==0){
                plocha[ranX][ranY] = 2;    
           }else{
               nandejNovou();
           }
       }else{
           if(plocha[ranX][ranY] ==0){
                plocha[ranX][ranY] =4;    
           }else{
               nandejNovou();
           }
       }
       jed.setPlocha(plocha);
    }
    
}

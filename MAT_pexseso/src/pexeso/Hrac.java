package pexeso;

/**
 *
 * @author janko
 */
public class Hrac {
    String jmeno;
    int score;

    public Hrac(String jmeno) {
        this.jmeno = jmeno;
        score = 0;
    }
    
    public void odhalil(){
        this.score++;
    }
   
}

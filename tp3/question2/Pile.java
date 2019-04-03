package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        if(taille<= 0){
            taille = CAPACITE_PAR_DEFAUT;
        }
        else{
            this.zone = new Object[taille];
            this.ptr = 0;
        }
    }

    public Pile() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object obj) throws PilePleineException {
        if( estPleine() ){
            throw new PilePleineException();
        }else{
            this.zone[this.ptr] = obj;
            this.ptr++;
        }
    }

    public Object depiler() throws PileVideException {
        if( estVide() ) {
            throw new PileVideException();
        }else{
            this.ptr--;
            return zone[ptr];
        }
}

    public Object sommet() throws PileVideException {
          //(estVide()) ? throw new PileVideException() : return zone[ptr-1];
          if(estVide() ) throw new PileVideException();
          else return zone[ptr-1];
    }

    public int capacite() {
        return zone.length;
    }

    public int taille() {
        return ptr;
    }

    public boolean estVide() {
        return taille() == 0 ;
    }

    public boolean estPleine() {
        // a completer
        return taille() == capacite();
    }

    public boolean equals(Object o) {
        if(!(o instanceof PileI)){
            return false;
        }else{
            PileI test = (PileI)o;
            int t = test.capacite();
            int t2 = zone.length;
            boolean isEqual = true ;
            if(t != t2) {
                return false ;
            }
            else{
                for (int index = ptr ; index >0 ; index--) {
                    Object a = null ;
                    try{
                        a = test.depiler() ;}
                        catch(PileVideException e){
                        };
                    if( a != zone[index]) {
                        isEqual = false;
                        break ;
                    }
                }
                return isEqual ;
            }
        }
        // StringBuffer stringB = new StringBuffer("[");
        // for (int index = ptr - 1; index >= 0;index--) {
            // stringB.append(zone[index].toString());
            // if ( index > 0 ) stringB.append("- ");
        // }
            // stringB.append("]");
            // return stringB.toString();  
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuffer stringB = new StringBuffer("[");
        for (int index = ptr - 1; index >= 0;index--) {
            stringB.append(zone[index].toString());
            if ( index > 0 ) stringB.append("- ");
        }
            stringB.append("]");
            return stringB.toString();
        }   
    
}
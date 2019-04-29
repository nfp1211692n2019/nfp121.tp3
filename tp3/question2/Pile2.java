package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        if(taille<= 0){
            taille = CAPACITE_PAR_DEFAUT;
        }
        else{
            this.zone = new Object[taille];
            this.ptr = 0;
        }
    }

    // constructeur fourni
    public Pile2() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if( estPleine() ){
            throw new PilePleineException();
        }else{
            this.zone[this.ptr] = obj;
            this.ptr++;
        }    }

    public Object depiler() throws PileVideException {
        if( estVide() ) {
            throw new PileVideException();
        }else{
            this.ptr--;
            return zone[ptr];
        }
    }

    public Object sommet() throws PileVideException {
        if(estVide() ) throw new PileVideException();
        else return zone[ptr-1];
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return taille() == 0 ;

    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return taille() == capacite();

    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        StringBuffer stringB = new StringBuffer("[");
        for (int index = ptr - 1; index >= 0;index--) {
            stringB.append(zone[index].toString());
            if ( index > 0 ) stringB.append(", ");
        }
            stringB.append("]");
            return stringB.toString();
    }

    public boolean equals(Object o) {
        // a completer
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        return ptr;

    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        return zone.length;

    }

} // Pile2.java

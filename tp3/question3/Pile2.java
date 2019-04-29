package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacité = CAPACITE_PAR_DEFAUT;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        if (taille > 0) this.stk =new Stack<T>();    
    }

    public Pile2(){
        this(CAPACITE_PAR_DEFAUT);
    }

    public int capacite() {
        return capacite;
    };

    public int taille() {
        return stk.size();
    };

    public boolean estPleine() {
        return taille == capacite;
    }
    public void empiler(T o) throws PilePleineException{
        if(!estPleine()){
            stk.push(o);
            taille++;
        }
        else {
            throw new PilePleineException();
        }
    }

    public T depiler() throws PileVideException{
        // à compléter
    }

    public T sommet() throws PileVideException{
        // à compléter
    }

    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile

} // Pile2
package Clases;

import java.util.Collections;
import java.util.Stack;

/**
 *
 * @autor Santiago Losada Borrajo
 */
public class ClaseSolitario {
    private Stack <Integer> mazo = new Stack <> ();
    
    public ClaseSolitario() {
        for ( int contador = 1; contador <= 40; contador++ ) {
            this.mazo.push(contador);
        }
        Collections.shuffle(this.mazo);
    }
    
    public ClaseSolitario(int n) {
        
    }
    
    public int verTop () {
        return(this.mazo.peek());
    }
    
    public int conseguirTop () {
        return(this.mazo.pop());
    }
    
    public void agregarCarta (int carta) {
        this.mazo.push(carta);
    }
    
    public boolean barajaVacia () {
        return(this.mazo.empty());
    }
    
    public void barajar () {
        Collections.shuffle(mazo);
    }
    
    public int capacidad( ) {
        Stack <Integer> aux = new Stack <> ();
        int contador = 0;
        while ( !this.barajaVacia() ) {
            aux.push(mazo.pop());
            contador++;
        }
        
        while ( !aux.empty() ) {
            this.mazo.push(aux.pop());
        }
        return contador;
    }
}

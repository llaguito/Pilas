/*
1)Fai un programa que lea unha cadena e a devolva o revés..
*/
package pilas;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @autor Santiago Losada Borrajo
 */
public class Exercicio1 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Stack <Character> pila = new Stack <> ();
        String palabra;
        
        System.out.print("\nIntroduce palabra: ");
        palabra = leer.nextLine();
        
        for ( int contador = 0; contador < palabra.length(); contador++ ) {
            pila.push(palabra.charAt(contador));
        }
        
        while ( !pila.empty()) {
            System.out.print(pila.pop());
        }        
    }

}

/*
2)Fai un programa que mire si un numero e capicúa..
*/
package pilas;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @autor Santiago Losada Borrajo
 */
public class Exercicio2 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int numero;
        boolean comprobacion = true;
        
        Stack <Integer> pila = new Stack <> ();
        Stack <Integer> pilaSecundaria = new Stack <> ();        
        Stack <Integer> pilaInversa = new Stack <> ();
        
        System.out.print("\nIntroduce numero: ");
        numero = leer.nextInt();
        
        while ( numero > 0 ) {
            pila.push(numero - (((numero/10)*10)));
            pilaSecundaria.push(numero - (((numero/10)*10)));
            numero = numero / 10;
        }
        
        while ( !pila.empty() ) {
            pilaInversa.push(pila.pop());
        }
       
        while ( !pilaSecundaria.empty() ) {
            if ( pilaSecundaria.pop() == pilaInversa.pop() ) {}
            else {
                comprobacion = false;
            }
        }
        
        if ( comprobacion == true ) {
            System.out.print("\nEl numero es capicúa.");
        }
        else {
            System.out.print("\nEl numero no es capicúa.");
        }
        
    }

}

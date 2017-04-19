package Solitario;

import Clases.ClaseSolitario;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @autor Santiago Losada Borrajo
 */
public class Solitario {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ClaseSolitario baraja = new ClaseSolitario();
        System.out.print("\n"+baraja.capacidad());
        String respuesta;
        int carta;
        String[] cartas = {"nada", "AC", "2C", "3C", "4C", "5C", "6C", "7C", "SC", "CC", "RC", "AO", "2O", "3O", "4O", "5O", "6O", "7O", "SO", "CO", "RO", "AB", "2B", "3B", "4B", "5B", "6B", "7B", "SB", "CB", "RB", "AE", "2E", "3E", "4E", "5E", "6E", "7E", "SE", "CE", "RE"};
        
        //Residuo
        ClaseSolitario residuo = new ClaseSolitario(0);
        
        //Montones
        Stack <Integer> copas = new Stack <> ();
        copas.push(0);
        Stack <Integer> oros = new Stack <> ();
        oros.push(0);
        Stack <Integer> bastos = new Stack <> ();
        bastos.push(0);
        Stack <Integer> espadas = new Stack <> ();
        espadas.push(0);
        
        //Comenzar juego
        System.out.print("\n¿Comenzar Juego?    Si/No    ");
        respuesta = leer.next();
               
        while ( respuesta.equalsIgnoreCase("Si") ) {
            while ( !baraja.barajaVacia() ) {
                carta = baraja.verTop();
                
                switch (carta) {
                    case 1:
                        copas.push(baraja.conseguirTop());
                        break;
                    
                    case 11:
                        oros.push(baraja.conseguirTop());
                        break;
                        
                    case 21:
                        bastos.push(baraja.conseguirTop());
                        break;
                        
                    case 31:
                        espadas.push(baraja.conseguirTop());
                        break;
                    
                }
                
                if ( (carta - 1) == copas.peek()) {
                    copas.push(baraja.conseguirTop());
                    }
                else if ( (carta - 1) == oros.peek()) {
                    oros.push(baraja.conseguirTop());
                }
                else if ( (carta - 1) == bastos.peek()) {
                    bastos.push(baraja.conseguirTop());
                }
                else if ( (carta - 1) == espadas.peek()) {
                    espadas.push(baraja.conseguirTop());
                }
                else {
                    residuo.agregarCarta(baraja.conseguirTop());
                }
            }
            
            System.out.print("\nLa barajas esta asi ahora mismo :\nQuedan "+residuo.capacidad()+" cartas en el mazo.\nEn las copas tenemos la siguiente carta: "+cartas[copas.peek()]+"\nEn los oros tenemos la siguiente carta: "+cartas[oros.peek()]+"\nEn los bastos tenemos la siguiente carta: "+cartas[bastos.peek()]+"\nEn las espadas tenemos la siguiente carta: "+cartas[espadas.peek()]);
            
            if ( residuo.barajaVacia() ) {
                System.out.print("\nEl juego ha terminado.");
                respuesta = "No";
            }
            else {
                System.out.print("\n¿Deseas continuar el juego?    Si/No  ");
                respuesta = leer.next();
            }
            
            
            //Construimos de nuevo la baraja y la barajamos
            while ( !residuo.barajaVacia() ) {
                baraja.agregarCarta(residuo.conseguirTop());
            }
            
            baraja.barajar();
            
        }
    }

}

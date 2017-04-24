package pilas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @autor Santiago Losada Borrajo
 */
public class Exercicio1ConVentana {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("PROBANDO");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea areaTexto1 = new JTextArea(10,50);
        JTextField areaTexto2 = new JTextField(40);
        areaTexto1.setLineWrap(true);
        areaTexto1.setEditable(false);
        ventana.add(areaTexto1, BorderLayout.NORTH);
        ventana.add(areaTexto2, BorderLayout.SOUTH);
        ventana.pack();//método utilizado para que se muestren los //elementos de la ventana 
        ventana.setVisible(true);
        
        
        Stack <Character> pila = new Stack <> ();
        
        areaTexto1.append("\nIntroduce una palabra: ");
        areaTexto2.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                String palabra;
                areaTexto1.append("\n"+((JTextField)e.getSource()).getText());
                palabra = areaTexto2.getText();
                areaTexto2.setText("");
        
                for ( int contador = 0; contador < palabra.length(); contador++ ) {
                    pila.push(palabra.charAt(contador));
                }
                
                areaTexto1.append("\n");
                while ( !pila.empty()) {
                    areaTexto1.append(""+pila.pop());
                } 

                areaTexto1.append("\nIntroduce una palabra: ");                
                
            }
        }
        );
    }
} 
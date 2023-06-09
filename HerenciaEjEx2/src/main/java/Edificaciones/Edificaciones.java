/*
Crear una superclase llamada Edificio con los siguientes atributos: ancho, alto y largo. La clase
edificio tendrá como métodos:
• Método calcularSuperficie(): calcula la superficie del edificio.
• Método calcularVolumen(): calcula el volumen del edifico.
Estos métodos serán abstractos y los implementarán las siguientes clases:
• Clase Polideportivo con su nombre y tipo de instalación que puede ser Techado o
Abierto, esta clase implementará los dos métodos abstractos y los atributos del padre.
• Clase EdificioDeOficinas con sus atributos número de oficinas, cantidad de personas
por oficina y número de pisos. Esta clase implementará los dos métodos abstractos y
los atributos del padre.
De esta clase nos interesa saber cuántas personas pueden trabajar en todo el edificio, el
usuario dirá cuántas personas entran en cada oficina, cuantas oficinas y el número de piso
(suponiendo que en cada piso hay una oficina). Crear el método cantPersonas(), que muestre
cuantas personas entrarían en un piso y cuantas en todo el edificio.
Por último, en el main vamos a crear un ArrayList de tipo Edificio. El ArrayList debe contener
dos polideportivos y dos edificios de oficinas. Luego, recorrer este array y ejecutar los
métodos calcularSuperficie y calcularVolumen en cada Edificio. Se deberá mostrar la
superficie y el volumen de cada edificio.
Además de esto, para la clase Polideportivo nos interesa saber cuántos polideportivos son
techados y cuantos abiertos. Y para la clase EdificioDeOficinas deberemos llamar al método
cantPersonas() y mostrar los resultados de cada edificio de oficinas.
 */
package Edificaciones;

import Entidades.Edificio;
import Entidades.EdificioDeOficinas;
import Entidades.Polideportivo;
import java.util.ArrayList;


/**
 *
 * @author Elio
 */
public class Edificaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Edificio> listEdificios = new ArrayList();
        int cont = 0;
        int contEdificios = 1;
        System.out.println("CREANDO EDIFICIOS");
        System.out.println("-------------------");
    do {
        System.out.println("Edificio N°" + contEdificios);
        EdificioDeOficinas edificio = new EdificioDeOficinas();
        edificio.crearEdificio();
        System.out.println(".........................");
        System.out.println("Polideportivo N°" + contEdificios);
        Polideportivo polideportivo = new Polideportivo();
        polideportivo.crearPolideportivo();
        System.out.println(".........................");
        listEdificios.add(edificio);
        listEdificios.add(polideportivo);
        cont++;
        contEdificios++;
    } while (cont !=2);
        int techados = 0;
        System.out.println("############################");
 
        for (Edificio edificio : listEdificios) {
            if(edificio instanceof EdificioDeOficinas){
                System.out.println("Edificio");
                System.out.println("----------------");
                edificio.calcularSuperficie();
                edificio.calcularVolumen();
                ((EdificioDeOficinas) edificio).cantPersonas();
                System.out.println("######################");
            }else if(edificio instanceof Polideportivo){
                System.out.println("Polideportivo " + ((Polideportivo) edificio).getNombre());
                System.out.println("-----------------");
                edificio.calcularSuperficie();
                if(((Polideportivo) edificio).getTechado()){
                edificio.calcularVolumen();
                techados++;
                }else{
                    System.out.println("Es un polideportivo a cielo abierto!");
                }
                System.out.println("######################");
            }
    
        }
        System.out.println("La cantidad de polideportivos techados son: " + techados);
 }
   
}

/*
Tenemos una clase padre Animal junto con sus 3 clases hijas Perro, Gato, Caballo.
La clase Animal tendrá como atributos el nombre, alimento, edad y raza del Animal.
Crear un método en la clase Animal a través del cual cada clase hija deberá mostrar luego un
mensaje por pantalla informando de que se alimenta.
 */
package Animales;

import Entidades.Animal;
import Entidades.Caballo;
import Entidades.Gato;
import Entidades.Perro;

/**
 *
 * @author Elio
 */
public class Animales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Animal perro1 = new Perro("Roco", "Carne", 3, "Pitbull");
        System.out.println("Perro: ");
        perro1.mostrarAlimento();
        Animal gato1 = new Gato("Lara", "Pescado", 2, "Persa");
        System.out.println("Gato: ");
        gato1.mostrarAlimento();
        Animal caballo1 = new Caballo("Grene", "Pasto", 5, "Pinto");
        System.out.println("Caballo: ");
        caballo1.mostrarAlimento();
    }
    
}

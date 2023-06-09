/*
 Se plantea desarrollar un programa que nos permita calcular el área y el perímetro de formas
geométricas, en este caso un círculo y un rectángulo. Ya que este cálculo se va a repetir en las
dos formas geométricas, vamos a crear una Interfaz, llamada calculosFormas que tendrá, los
dos métodos para calcular el área, el perímetro y el valor de PI como constante.
Desarrollar el ejercicio para que las formas implementen los métodos de la interfaz y se
calcule el área y el perímetro de los dos. En el main se crearán las formas y se mostrará el
resultado final.
Área circulo: PI * radio ^ 2 / Perímetro circulo: PI * diámetro.
Área rectángulo: base * altura / Perímetro rectángulo: (base + altura) * 2.
 */
package Objetos;

import Entidades.Circulo;
import Entidades.Rectangulo;
import java.util.Scanner;

/**
 *
 * @author Elio
 */
public class FormandoObjetos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Circulo c1 = new Circulo();
        Rectangulo r1 = new Rectangulo();
        
        System.out.println("CÍRCULO");
        System.out.println("------------------");
        System.out.print("Ingrese el radio del circulo: ");
        double radio = leer.nextDouble();
        c1.setRadio(radio);
        System.out.println("-------------------");
        System.out.println("El area del círculo es: " + c1.calcularArea());
        System.out.println("El perímetro del círculo es: " + c1.calcularPerimetro());
        
        System.out.println("RECTANGULO");
        System.out.println("------------------");
        System.out.print("Ingrese la base del rectangulo: ");
        double base = leer.nextDouble();
        r1.setBase(base);
        System.out.print("Ingrese la altura del rectangulo: ");
        double altura = leer.nextDouble();
        r1.setAltura(altura);
        System.out.println("-------------------");
        System.out.println("El area del Rectangulo es: " + r1.calcularArea());
        System.out.println("El perímetro del Rectangulo es: " + r1.calcularPerimetro());
    }
    
}

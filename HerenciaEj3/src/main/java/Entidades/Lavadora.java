/*
Siguiendo el ejercicio anterior, en el main vamos a crear un ArrayList de Electrodomésticos
para guardar 4 electrodomésticos, ya sean lavadoras o televisores, con valores ya asignados.
Luego, recorrer este array y ejecutar el método precioFinal() en cada electrodoméstico. Se
deberá también mostrar el precio de cada tipo de objeto, es decir, el precio de todos los
televisores y el de las lavadoras. Una vez hecho eso, también deberemos mostrar, la suma del
precio de todos los Electrodomésticos. Por ejemplo, si tenemos una lavadora con un precio de
2000 y un televisor de 5000, el resultado final será de 7000 (2000+5000) para
electrodomésticos, 2000 para lavadora y 5000 para televisor.
 */
package Entidades;

import java.util.Scanner;

/**
 *
 * @author Elio
 */
public final class Lavadora extends Electrodomestico {
    
     Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private int carga;

    public Lavadora() {
    }

    public Lavadora(int carga, int precio, String color, String consumo, int peso) {
        super(precio, color, consumo, peso);
        this.carga = carga;
    }

    public void crearLavadora() {
        crearElectrodomestico();
        System.out.println("Ingrese carga en Kg.");
        this.carga = leer.nextInt();

    }
    
    public void mostrarLavadora(){
        
        System.out.println("Color: " + this.color);
        System.out.println("Consumo: " + this.consumo);
        System.out.println("Peso: " + this.peso);
        System.out.println("Carga: " + this.carga);
        System.out.println("Precio: " + this.precio);
    }

    @Override
    public void precioFinal() {
        super.precioFinal();
        if (carga > 30) {
            this.precio += 500;
        }

    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    @Override
    public String toString() {
        System.out.println("LAVADORA");
        return super.toString(); 
    }
}

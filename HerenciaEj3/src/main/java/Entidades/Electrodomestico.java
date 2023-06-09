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

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Elio
 */
public class Electrodomestico {
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    protected int precio;
    protected String color;
    protected String consumo;
    protected int peso;
    protected ArrayList<Electrodomestico> listElectro;

    public Electrodomestico() {

    }

    public Electrodomestico(int precio, String color, String consumo, int peso) {
        this.precio = precio;
        this.color = color;
        this.consumo = consumo;
        this.peso = peso;
    }

    public void comprobarConsumo(String consumo) {

        String[] letras = {"A", "B", "C", "D", "E", "F"};

        for (int i = 0; i < letras.length; i++) {
            if (consumo.equalsIgnoreCase(letras[i])) {
                this.consumo = consumo;
                break;
            } else {
                this.consumo = "F";
            }
        }

    }

    public void comprobarColor(String colorAux) {

        String[] colores = {"Blanco", "Negro", "Azul", "Rojo", "Gris"};

        for (int i = 0; i < colores.length; i++) {
            if (colores[i].equalsIgnoreCase(colorAux)) {
                this.color = colorAux;
                break;
            } else {
                this.color = "Blanco";
            }
        }

    }

    public void crearElectrodomestico() {

        this.precio = 1000;
        System.out.println("Ingrese color");
        String colorAux = leer.next();
        comprobarColor(colorAux);
        System.out.println("Ingrese tipo de consumo (A/B/C/D/E/F)");
        String consumoAux = leer.next().toUpperCase();
        comprobarConsumo(consumoAux);
        System.out.println("Ingrese peso");
        int pesoAux = leer.nextInt();
        this.peso = pesoAux;

    }

    public void precioFinal() {

        switch (this.consumo) {
            case "A":
                this.precio += 1000;
                break;
            case "B":
                this.precio += 800;
                break;
            case "C":
                this.precio += 600;
                break;
            case "D":
                this.precio += 500;
                break;
            case "E":
                this.precio += 300;
                break;
            case "F":
                this.precio += 100;
                break;
            default:
                break;
        }

        if (peso >= 1 && peso <= 19) {
            this.precio += 100;
        } else if (peso >= 20 && peso <= 59) {
            this.precio += 500;
        } else if (peso >= 50 && peso <= 79) {
            this.precio += 800;
        } else {
            this.precio += 1000;
        }

    }
    
    public void crearLista(ArrayList<Electrodomestico> listaElectro){
    
        this.listElectro = listaElectro;
    }

    public void sumarElectro(){
        int sumaTotal = 0;
        for (Electrodomestico electrodomestico : listElectro) {
            sumaTotal += electrodomestico.getPrecio();
        }
        System.out.println("La suma total de electrodomesticos es: $" + sumaTotal);
    }
    
//     public void mostrarElectro(){
//    
//        for (Electrodomestico electrodomestico : listElectro) {
//            System.out.println(electrodomestico);
//        }
//    
//    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "################";
  }
}

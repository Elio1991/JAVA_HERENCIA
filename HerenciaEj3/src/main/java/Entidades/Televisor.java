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
public final class Televisor extends Electrodomestico {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private int resolucion;
    private boolean sintonizadorTDT;

    public Televisor() {
    }

    public Televisor(int resolucion, boolean sintonizadorTDT, int precio, String color, String consumo, int peso) {
        super(precio, color, consumo, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public void crearTelevisor() {
        crearElectrodomestico();
        System.out.println("Ingrese resolucion (en pulgadas)");
        this.resolucion = leer.nextInt();
        System.out.println("Posee sintonizador TDT? (S/N)");
        String resp = leer.next();
        boolean resp1;
        if (resp.equalsIgnoreCase("S")) {
            resp1 = true;
        } else {
            resp1 = false;
        }
        this.sintonizadorTDT = resp1;

    }

    @Override
    public void precioFinal() {
        super.precioFinal();

        if (resolucion > 40) {
            int aumento = (int) (precio * 0.30);
            this.precio += aumento;
        }

        if (sintonizadorTDT) {
            this.precio += 500;
        }

    }
    public void mostrarTv(){
        String TDT;
        
        System.out.println("Color: " + this.color);
        System.out.println("Consumo: " + this.consumo);
        System.out.println("Peso: " + this.peso);
        System.out.println("Resolución: " + this.resolucion);
        if(this.sintonizadorTDT){
        TDT = "SI";
        }else{
        TDT = "NO";
        }
        System.out.println("Sintonizador TDT: " + TDT);
        System.out.println("Precio: " + this.precio);
    }
    
    public int getResolucion() {
        return resolucion;
    }

    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    public void setSintonizadorTDT(boolean sintonizadorTDT) {
        this.sintonizadorTDT = sintonizadorTDT;
    }

    @Override
    public String toString() {
        System.out.println("TELEVISOR");
        return super.toString();
    }
}

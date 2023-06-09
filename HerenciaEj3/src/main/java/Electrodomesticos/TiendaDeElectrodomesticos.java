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
package Electrodomesticos;

import Entidades.Electrodomestico;
import Entidades.Lavadora;
import Entidades.Televisor;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Elio
 */
public class TiendaDeElectrodomesticos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ArrayList<Electrodomestico> listaElectro = new ArrayList();
        Electrodomestico electros = new Electrodomestico();
        int cont = 0;
        int resp;
        do {
            do {
                System.out.println("Que electrodomestico desea ingresar: ");
                System.out.println("1. Lavadora");
                System.out.println("2. Televisor");
                System.out.println("3. salir");
                resp = leer.nextInt();

                switch (resp) {

                    case 1:
                        Lavadora e1 = new Lavadora();
                        System.out.println("*LAVADORA*");
                        e1.crearLavadora();
                        e1.precioFinal();
                        listaElectro.add(e1);
                        cont++;
                        break;
                    case 2:
                        Televisor e2 = new Televisor();
                        System.out.println("*TELEVISOR*");
                        e2.crearTelevisor();
                        e2.precioFinal();
                        listaElectro.add(e2);
                        cont++;
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        cont = 4;
                        resp = 3;
                        break;
                    default:
                        break;
                }
                while (resp != 1 && resp != 2 && resp != 3) {
                    System.out.println("Ingrese una opción válida");
                    resp = leer.nextInt();
                }
               if(cont==4){
               resp = 3;
               }
            } while (resp != 3);

        } while (cont != 4);

        electros.crearLista(listaElectro);

        for (Electrodomestico electrodomestico : listaElectro) {
            if (electrodomestico instanceof Lavadora) {
            System.out.println("-----------------------");
            System.out.println(electrodomestico.toString());
            System.out.println("Precio: $" + electrodomestico.getPrecio());
            System.out.println("Color: " + electrodomestico.getColor());
            System.out.println("Consumo: " + electrodomestico.getConsumo());
            System.out.println("Peso: " + electrodomestico.getPeso());
            System.out.println("Carga: " + ((Lavadora) electrodomestico).getCarga());
            } else if (electrodomestico instanceof Televisor) {
                System.out.println(electrodomestico.toString());
                System.out.println("Precio: $" + electrodomestico.getPrecio());
                System.out.println("Color: " + electrodomestico.getColor());
                System.out.println("Consumo: " + electrodomestico.getConsumo());
                System.out.println("Peso: " + electrodomestico.getPeso());
                System.out.println("Pulgadas: " + ((Televisor) electrodomestico).getResolucion());
                String res = ((Televisor) electrodomestico).isSintonizadorTDT() ? "SI" : "NO";
                System.out.println("Sintonizador TDT: " + res);
            }
        }

        electros.sumarElectro();

    }
}

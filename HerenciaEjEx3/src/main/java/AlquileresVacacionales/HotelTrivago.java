/*
Una compañía de promociones turísticas desea mantener información sobre la infraestructura
de alojamiento para turistas, de forma tal que los clientes puedan planear sus vacaciones de
acuerdo con sus posibilidades. Los alojamientos se identifican por un nombre, una dirección,
una localidad y un gerente encargado del lugar. La compañía trabaja con dos tipos de
alojamientos: Hoteles y Alojamientos Extrahoteleros.
Los Hoteles tienen como atributos: Cantidad de Habitaciones, Número de Camas, Cantidad de
Pisos, Precio de Habitaciones. Y estos pueden ser de cuatro o cinco estrellas. Las
características de las distintas categorías son las siguientes:
• Hotel **** Cantidad de Habitaciones, Número de camas, Cantidad de Pisos, Gimnasio,
Nombre del Restaurante, Capacidad del Restaurante, Precio de las Habitaciones.
• Hotel ***** Cantidad de Habitaciones, Número de camas, Cantidad de Pisos, Gimnasio,
Nombre del Restaurante, Capacidad del Restaurante, Cantidad Salones de
Conferencia, Cantidad de Suites, Cantidad de Limosinas, Precio de las Habitaciones.
Los gimnasios pueden ser clasificados por la empresa como de tipo “A” o de tipo “B”, de
acuerdo a las prestaciones observadas. Las limosinas están disponibles para cualquier
cliente, pero sujeto a disponibilidad, por lo que cuanto más limosinas tenga el hotel, más caro
será.
El precio de una habitación debe calcularse de acuerdo con la siguiente fórmula:
PrecioHabitación = $50 + ($1 x capacidad del hotel) + (valor agregado por restaurante) + (valor
agregado por gimnasio) + (valor agregado por limosinas).
Donde:
Valor agregado por el restaurante:
• $10 si la capacidad del restaurante es de menos de 30 personas.
• $30 si está entre 30 y 50 personas.
• $50 si es mayor de 50.
Valor agregado por el gimnasio:
• $50 si el tipo del gimnasio es A.
• $30 si el tipo del gimnasio es B.
Valor agregado por las limosinas:
• $15 por la cantidad de limosinas del hotel.

En contraste, los Alojamientos Extra hoteleros proveen servicios diferentes a los de los
hoteles, estando más orientados a la vida al aire libre y al turista de bajos recursos. Por cada
Alojamiento Extrahotelero se indica si es privado o no, así como la cantidad de metros
cuadrados que ocupa. Existen dos tipos de alojamientos extrahoteleros: los Camping y las
Residencias. Para los Camping se indica la capacidad máxima de carpas, la cantidad de baños
disponibles y si posee o no un restaurante dentro de las instalaciones. Para las residencias se
indica la cantidad de habitaciones, si se hacen o no descuentos a los gremios y si posee o no
campo deportivo. Realizar un programa en el que se representen todas las relaciones
descriptas.
Realizar un sistema de consulta que le permite al usuario consultar por diferentes criterios:
• todos los alojamientos.
• todos los hoteles de más caro a más barato.
• todos los campings con restaurante
• todos las residencias que tienen descuento.
 */
package AlquileresVacacionales;

import Entidades.Alojamiento;
import Entidades.Camping;
import Entidades.Hotel4;
import Entidades.Hotel5;
import Entidades.Residencia;
import Service.HotelService;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Elio
 */
public class HotelTrivago {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Alojamiento> alojaArray = new ArrayList();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        HotelService hs = new HotelService();

        Hotel4 hot1 = new Hotel4(25, 52, 3, "B", "Carlitos", 35, "El Manco", "Olmos 458", "CABA", "Pichici");
        Hotel4 hot2 = new Hotel4(70, 280, 7, "A", "Lola", 135, "El Okupa", "Balcarce 50", "CABA", "Alberto");
        Hotel5 hot3 = new Hotel5(5, 10, 10, 250, 10, 15, "A", "Pepino", 150, "Los otros Rochos", "Alcorta 1550", "CABA", "Mauricio");
        Hotel5 hot4 = new Hotel5(3, 6, 5, 150, 5, 10, "A", "Kansas", 100, "Instituto P", "Junin y Ayacucho", "CABA", "La Cris");

        alojaArray.add(hot1);
        alojaArray.add(hot2);
        alojaArray.add(hot3);
        alojaArray.add(hot4);

        Camping aeh1 = new Camping(50, 8, true, true, 15000, "Vuelta y vuelta", "Ruta 25 Km 428", "Miramar", "Sergio");
        Camping aeh2 = new Camping(60, 10, false, true, 25000, "Quilombo Express", "Ruta 11, Km 325", "San Beranrdo", "Lilita");
        Residencia aeh3 = new Residencia(5, false, false, true, 5000, "La Chinche", "Av. 3 1548", "Villa Gessell", "Maximo");
        Residencia aeh4 = new Residencia(25, true, true, true, 15000, "El Chori y la Coca", "Av. Bunge 158", "Pinamar", "Hugito");

        alojaArray.add(aeh1);
        alojaArray.add(aeh2);
        alojaArray.add(aeh3);
        alojaArray.add(aeh4);

        for (Alojamiento aux : alojaArray) {
            if (aux instanceof Hotel4) {
                ((Hotel4) aux).setPrecioHab(aux.calcularPrecio(aux));
                continue;
            }
            if (aux instanceof Hotel5) {
                ((Hotel5) aux).setPrecioHab(aux.calcularPrecio(aux));
            }
        }

        int opc;
        do {
            System.out.println("MENU");
            System.out.println("--------");
            System.out.println("1.- Listado de Alojamientos");
            System.out.println("2.- Ver precios Hoteles");
            System.out.println("3.- Ordenar x Precio");
            System.out.println("4.- Ver los campings con Resto");
            System.out.println("5.- Residencias con Discointo");
            System.out.println("6.- ");
            System.out.println("7.- ");
            System.out.println("8.- ");
            System.out.println("9.- Salir");

            opc = leer.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("");
                    System.out.println("Listado de Alojamientos");
                    for (Alojamiento aux : alojaArray) {
                        System.out.println(aux);
                    }
                    break;
                case 2:
                    for (Alojamiento aux : alojaArray) {
                        if (aux instanceof Hotel4) {
                            System.out.println(((Hotel4) aux).getPrecioHab());
                            continue;
                        }
                        if (aux instanceof Hotel5) {
                            System.out.println(((Hotel5) aux).getPrecioHab());
                        }
                    }
                    break;
                case 3:
                    hs.ordenarPorPrecio(alojaArray);
                    break;
                case 4:
                    hs.mostrarCampConResto(alojaArray);
                    break;
                case 5:
                    hs.residenciasConDesc(alojaArray);

            }
        } while (opc != 9);
    }

}

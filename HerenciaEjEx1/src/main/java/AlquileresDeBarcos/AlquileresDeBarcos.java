/*
En un puerto se alquilan amarres para barcos de distinto tipo. Para cada Alquiler se guarda: el
nombre, documento del cliente, la fecha de alquiler, fecha de devolución, la posición del
amarre y el barco que lo ocupará.
Un Barco se caracteriza por: su matrícula, su eslora en metros y año de fabricación.
Sin embargo, se pretende diferenciar la información de algunos tipos de barcos especiales:
• Número de mástiles para veleros.
• Potencia en CV para barcos a motor.
• Potencia en CV y número de camarotes para yates de lujo.
Un alquiler se calcula multiplicando el número de días de ocupación (calculado con la fecha de
alquiler y devolución), por un valor módulo de cada barco (obtenido simplemente
multiplicando por 10 los metros de eslora).
En los barcos de tipo especial el módulo de cada barco se calcula sacando el módulo normal y
sumándole el atributo particular de cada barco. En los veleros se suma el número de mástiles,
en los barcos a motor se le suma la potencia en CV y en los yates se suma la potencia en CV y
el número de camarotes.
Utilizando la herencia de forma apropiada, deberemos programar en Java, las clases y los
métodos necesarios que permitan al usuario elegir el barco que quiera alquilar y mostrarle el
precio final de su alquiler.
 */
package AlquileresDeBarcos;

import Entidades.Alquiler;
import Entidades.Barco;
import Entidades.BarcoMotor;
import Entidades.Veleros;
import Entidades.YatesDeLujo;
import java.util.Scanner;

/**
 *
 * @author Elio
 */
public class AlquileresDeBarcos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Alquiler alq = new Alquiler();
        int opc;
      
        //public Veleros(int mastiles, int matricula, int eslora, int añoDeFabricacion)
        Veleros velero = new Veleros(3, 12345, 15, 2000); 
        //public BarcoMotor(int CV, int matricula, int eslora, int añoDeFabricacion) {
        BarcoMotor lancha = new BarcoMotor(2000, 54321, 5, 2010);
        //public YatesDeLujo(int CV, int camarotes, int matricula, int eslora, int añoDeFabricacion)
        YatesDeLujo yate = new YatesDeLujo(5000, 25, 45678, 20, 1998); 
        
        System.out.println("ALQUILER DE AMARRES PARA BARCOS");
        System.out.println("###################");
        
        
        System.out.println("Seleccione el tipo de barco que desea amarrar");
        System.out.println("1. Velero");
        System.out.println("2. Lancha");
        System.out.println("3. Yate");
      
            opc = leer.nextInt();
            
            while(opc != 1 && opc != 2 && opc != 3 && opc != 4){
                System.out.println("Ingrese una opcion válida");
                opc = leer.nextInt();
            }
            switch (opc) {
                case 1:
                    alq.alquilerBarco(velero);
                   
                    break;
                case 2: 
                    alq.alquilerBarco(lancha);
                 
                    break;
                case 3:
                    alq.alquilerBarco(yate);
                 
                    break;        
            }
  
        if(opc == 1){
       System.out.println("Nombre: " + alq.getNombre());
       System.out.println("DNI: " + alq.getDNI());
       System.out.println("Fecha Alquiler: " + alq.getFechaAlquiler());
       System.out.println("Fecha de devolucion: " + alq.getFechaDevolucion());
       System.out.println("Posicion del Amarre N°" + alq.getPosicionAmarre());
       System.out.println("TIPO DE BARCO: VELERO ");
       System.out.println("-----------------------");
       System.out.println("Matricula: " + velero.getMatricula());
       System.out.println("Año de fabricación: " + velero.getAñoDeFabricacion());
       
       System.out.println("Costo del alquiler: " + alq.calcularAlquiler());
        }
        if(opc == 2){
       System.out.println("Nombre: " + alq.getNombre());
       System.out.println("DNI: " + alq.getDNI());
       System.out.println("Fecha Alquiler: " + alq.getFechaAlquiler());
       System.out.println("Fecha de devolucion: " + alq.getFechaDevolucion());
       System.out.println("Posicion del Amarre N°" + alq.getPosicionAmarre());
       System.out.println("TIPO DE BARCO: LANCHA ");
       System.out.println("-----------------------");
       System.out.println("Matricula: " + lancha.getMatricula());
       System.out.println("Año de fabricación: " + lancha.getAñoDeFabricacion());
       System.out.println("Costo del alquiler: " + alq.calcularAlquiler());
        }
        if(opc == 3){
       System.out.println("Nombre: " + alq.getNombre());
       System.out.println("DNI: " + alq.getDNI());
       System.out.println("Fecha Alquiler: " + alq.getFechaAlquiler());
       System.out.println("Fecha de devolucion: " + alq.getFechaDevolucion());
       System.out.println("Posicion del Amarre N°" + alq.getPosicionAmarre());
       System.out.println("TIPO DE BARCO: YATE ");
       System.out.println("-----------------------");
       System.out.println("Matricula: " + yate.getMatricula());
       System.out.println("Año de fabricación: " + yate.getAñoDeFabricacion());
       System.out.println("Costo del alquiler: " + alq.calcularAlquiler());
        }
    }
}

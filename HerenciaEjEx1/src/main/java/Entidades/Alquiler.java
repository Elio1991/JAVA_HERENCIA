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
package Entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import java.util.Scanner;

/**
 *
 * @author Elio
 */
public class Alquiler {
   
   Scanner leer = new Scanner(System.in).useDelimiter("\n");
   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
   //LocalDate fecha = LocalDate.parse("01/05/2023", formatter); // Formato personalizado (DD/MM/AAAA)
   protected String nombre;
   protected Integer DNI;
   protected LocalDate fechaAlquiler;
   protected LocalDate fechaDevolucion;
   protected int posicionAmarre;
   protected Barco barco;

    public Alquiler() {
    }

    public Alquiler(String nombre, Integer DNI, LocalDate fechaAlquiler, LocalDate fechaDevolucion, int posicionAmarre, Barco barco) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.fechaAlquiler = fechaAlquiler;

        this.fechaDevolucion = fechaDevolucion;
        this.posicionAmarre = posicionAmarre;
        this.barco = barco;
    }

    public Scanner getLeer() {
        return leer;
    }

    public void setLeer(Scanner leer) {
        this.leer = leer;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDNI() {
        return DNI;
    }

    public void setDNI(Integer DNI) {
        this.DNI = DNI;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getPosicionAmarre() {
        return posicionAmarre;
    }

    public void setPosicionAmarre(int posicionAmarre) {
        this.posicionAmarre = posicionAmarre;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    @Override
    public String toString() {
        return "Alquiler{nombre=" + nombre + ", DNI=" + DNI + ", fechaAlquiler=" + fechaAlquiler + ", fechaDevolucion=" + fechaDevolucion + ", posicionAmarre=" + posicionAmarre + ", barco=" + barco + '}';
    }
   
   
   public void alquilerBarco(Barco barquito){
       
       System.out.println("Ingrese su nombre");
       this.nombre = leer.next();
       System.out.println("Ingrese su dni");
       this.DNI = leer.nextInt();
       System.out.println("Ingrese la fecha del alquiler (dd/MM/yyyy)");
       this.fechaAlquiler = LocalDate.parse(leer.next(), formatter);
       System.out.println("Ingrese la fecha de la devolucion (dd/MM/yyyy)");
       this.fechaDevolucion = LocalDate.parse(leer.next(), formatter);
       System.out.println("Ingrese la posicion del amarre");
       this.posicionAmarre = leer.nextInt();
       this.barco = barquito;
       Alquiler alq = new Alquiler(nombre, DNI, fechaAlquiler, fechaDevolucion, posicionAmarre, barco );
   }
    public int calcularAlquiler(){
    
        long ocupacion = ChronoUnit.DAYS.between(fechaAlquiler, fechaDevolucion);
         int modulo = this.barco.calcularModulo();
        return (int) (ocupacion * modulo);
    }
}

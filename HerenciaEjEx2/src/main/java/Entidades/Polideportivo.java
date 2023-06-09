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
package Entidades;

/**
 *
 * @author Elio
 */
public final class Polideportivo extends Edificio {

    private String nombre;
    private Boolean techado; //Techado o Abierto.
    private int cantTechados;

    public Polideportivo() {
    }

    public Polideportivo(String nombre, Boolean techado, int cantTechados, int ancho, int alto, int largo) {
        super(ancho, alto, largo);
        this.nombre = nombre;
        this.techado = techado;
        this.cantTechados = cantTechados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getTechado() {
        return techado;
    }

    public void setTechado(Boolean techado) {
        this.techado = techado;
    }

    public int getCantTechados() {
        return cantTechados;
    }

    public void setCantTechados(int cantTechados) {
        this.cantTechados = cantTechados;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public void crearPolideportivo() {
        System.out.print("Ingrese el nombre del polideportivo: ");
        this.nombre = leer.next();
        System.out.print("El polideportivo es techado? (S/N): ");
        String resp = leer.next().toUpperCase();
        if (resp.equalsIgnoreCase("S")) {
            this.techado = true;
            System.out.print("Ingrese el largo en Mts del polideportivo: ");
            this.largo = leer.nextInt();
            System.out.print("Ingrese el ancho en Mts del polideportivo: ");
            this.ancho = leer.nextInt();
            System.out.print("Ingrese la altura en Mts del polideportivo: ");
            this.alto = leer.nextInt();
        } else {
            this.techado = false;
            System.out.print("Ingrese el largo en Mts del polideportivo: ");
            this.largo = leer.nextInt();
            System.out.print("Ingrese el ancho en Mts del polideportivo: ");
            this.ancho = leer.nextInt();
            this.alto = 0;
        }

    }

    @Override
    public void calcularSuperficie() {

        int sup = 2 * (this.largo * this.ancho + this.largo * this.alto + this.ancho * this.alto);
        System.out.println("La superficie total del polideportivo es: " + sup);
    }

    @Override
    public void calcularVolumen() {
        //Volumen = largo * ancho * altura
        int vol = this.largo * this.ancho * this.alto;
        System.out.println("El volúmen total del polideportivo es: " + vol);
    }

}

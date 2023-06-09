/*
Crear una superclase llamada Edificio con los siguientes atributos: ancho, alto y largo. La clase
edificio tendrá como métodos:
• Método calcularSuperficie(): calcula la superficie del edificio.
• Método calcularVolumen(): calcula el volumen del edificio.
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
public final class EdificioDeOficinas extends Edificio{
  
    private int numOficinas;
    private int cantPersxOficina;
    private int NumPisos;

    public EdificioDeOficinas() {
    }

    public EdificioDeOficinas(int numOficinas, int cantPersxOficina, int NumPisos, int ancho, int alto, int largo) {
        super(ancho, alto, largo);
        this.numOficinas = numOficinas;
        this.cantPersxOficina = cantPersxOficina;
        this.NumPisos = NumPisos;
    }

    public int getNumOficinas() {
        return numOficinas;
    }

    public void setNumOficinas(int numOficinas) {
        this.numOficinas = numOficinas;
    }

    public int getCantPersxOficina() {
        return cantPersxOficina;
    }

    public void setCantPersxOficina(int cantPersxOficina) {
        this.cantPersxOficina = cantPersxOficina;
    }

    public int getNumPisos() {
        return NumPisos;
    }

    public void setNumPisos(int NumPisos) {
        this.NumPisos = NumPisos;
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

    @Override
    public String toString() {
        return super.toString(); 
    }

    
    @Override
    public void calcularSuperficie() {
        //Superficie = 2 * (largo * ancho + largo * altura + ancho * altura)
        
        int sup = 2 * (this.largo * this.ancho + this.largo * this.alto + this.ancho * this.alto);
        System.out.println("La superficie total del edificio es: " + sup);
    }

    @Override
    public void calcularVolumen() {
        //Volumen = largo * ancho * altura
        
        int vol = this.largo * this.ancho * this.alto;
        System.out.println("El volúmen total del edificio es: " + vol);

    }
    
    public void crearEdificio(){
        System.out.print("Ingrese el largo en Mts del edificio: ");
        this.largo = leer.nextInt();
        System.out.print("Ingrese el ancho en Mts del edificio: ");
        this.ancho = leer.nextInt();
        System.out.print("Ingrese la altura en Mts del edificio: ");
        this.alto = leer.nextInt();
        System.out.print("Ingrese la cantidad de pisos: ");
        int aux = leer.nextInt();
        this.NumPisos = aux;
        System.out.print("Ingrese la cantidad de personas que trabajan en una oficina: ");
        this.cantPersxOficina = leer.nextInt();
        System.out.println("Tendra una oficina por piso");
        this.numOficinas = aux;
    }
    
    public void cantPersonas(){
    /*De esta clase nos interesa saber cuántas personas pueden trabajar en todo el edificio, el
    usuario dirá cuántas personas entran en cada oficina, cuantas oficinas y el número de piso
    (suponiendo que en cada piso hay una oficina). Crear el método cantPersonas(), que muestre
    cuantas personas entrarían en un piso y cuantas en todo el edificio.*/
        
        System.out.println("El número de pisos del edificio es: " + this.NumPisos);
        System.out.println("Cantidad de personas que entran por piso: " + this.cantPersxOficina);
        int cantTotal = this.cantPersxOficina * this.NumPisos;
        System.out.println("El total de personas trabajando en el edificio es: " + cantTotal);
    }
}

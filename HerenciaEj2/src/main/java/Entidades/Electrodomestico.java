/*
Crear una superclase llamada Electrodoméstico con los siguientes atributos: precio, color,
consumo energético (letras entre A y F) y peso.
Los constructores que se deben implementar son los siguientes:
• Un constructor vacío.
• Un constructor con todos los atributos pasados por parámetro.
Los métodos a implementar son:
• Métodos getters y setters de todos los atributos.
• Método comprobarConsumoEnergetico(char letra): comprueba que la letra es correcta,
sino es correcta usara la letra F por defecto. Este método se debe invocar al crear el
objeto y no será visible.
• Método comprobarColor(String color): comprueba que el color es correcto, y si no lo es,
usa el color blanco por defecto. Los colores disponibles para los electrodomésticos son
blanco, negro, rojo, azul y gris. No importa si el nombre está en mayúleerulas o en
minúleerulas. Este método se invocará al crear el objeto y no será visible.

• Metodo crearElectrodomestico(): le pide la información al usuario y llena el
electrodoméstico, también llama los métodos para comprobar el color y el consumo. Al
precio se le da un valor base de $1000.
• Método precioFinal(): según el consumo energético y su tamaño, aumentará el valor del
precio. Esta es la lista de precios:

A continuación, se debe crear una subclase llamada Lavadora, con el atributo carga,
además de los atributos heredados.
Los constructores que se implementarán serán:
• Un constructor vacío.
• Un constructor con la carga y el resto de los atributos heredados. Recuerda que debes
llamar al constructor de la clase padre.
Los métodos que se implementara serán:
• Método get y set del atributo carga.
• Método crearLavadora (): este método llama a crearElectrodomestico() de la clase
padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos
el atributo propio de la lavadora.
• Método precioFinal(): este método será heredado y se le sumará la siguiente
funcionalidad. Si tiene una carga mayor de 30 kg, aumentará el precio en $500, si la
carga es menor o igual, no se incrementará el precio. Este método debe llamar al
método padre y añadir el código necesario. Recuerda que las condiciones que hemos
visto en la clase Electrodoméstico también deben afectar al precio.
Se debe crear también una subclase llamada Televisor con los siguientes atributos:
resolución (en pulgadas) y sintonizador TDT (booleano), además de los atributos
heredados.
Los constructores que se implementarán serán:
• Un constructor vacío.
• Un constructor con la resolución, sintonizador TDT y el resto de los atributos
heredados. Recuerda que debes llamar al constructor de la clase padre.
LETRA PRECIO
A $1000
B $800
C $600
D $500
E $300
F $100

PESO PRECIO
Entre 1 y 19 kg $100
Entre 20 y 49 kg $500
Entre 50 y 79 kg $800
Mayor que 80 kg $1000

Los métodos que se implementara serán:
• Método get y set de los atributos resolución y sintonizador TDT.
• Método crearTelevisor(): este método llama a crearElectrodomestico() de la clase
padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos
los atributos del televisor.
• Método precioFinal(): este método será heredado y se le sumará la siguiente
funcionalidad. Si el televisor tiene una resolución mayor de 40 pulgadas, se
incrementará el precio un 30% y si tiene un sintonizador TDT incorporado, aumentará
$500. Recuerda que las condiciones que hemos visto en la clase Electrodomestico
también deben afectar al precio.
Finalmente, en el main debemos realizar lo siguiente:
Vamos a crear una Lavadora y un Televisor y llamar a los métodos necesarios para mostrar
el precio final de los dos electrodomésticos.
 */
package Entidades;


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
    

    public Electrodomestico() {

    }

    public Electrodomestico(int precio, String color, String consumo, int peso) {
        this.precio = precio;
        this.color = color;
        this.consumo = consumo;
        this.peso = peso;
    }

   

    protected void comprobarConsumo(String consumo) {

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

    protected void comprobarColor(String color) {

        String[] colores = {"Blanco", "Negro", "Azul", "Rojo", "Gris"};

        for (int i = 0; i < colores.length; i++) {
            if (color.equalsIgnoreCase(colores[i])) {
                this.color = color;
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
        return "Electrodomestico{" + "precio=" + precio + ", color=" + color + ", consumo=" + consumo + ", peso=" + peso + '}';
    }
}

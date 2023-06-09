/*
Sistema Gestión Facultad. Se pretende realizar una aplicación para una facultad que gestione
la información sobre las personas vinculadas con la misma y que se pueden clasificar en tres
tipos: estudiantes, profesores y personal de servicio. A continuación, se detalla qué tipo de
información debe gestionar esta aplicación:
• Por cada persona, se debe conocer, al menos, su nombre y apellidos, su número de
identificación y su estado civil.
• Con respecto a los empleados, sean del tipo que sean, hay que saber su año de
incorporación a la facultad y qué número de despacho tienen asignado.
• En cuanto a los estudiantes, se requiere almacenar el curso en el que están
matriculados.
• Por lo que se refiere a los profesores, es necesario gestionar a qué departamento
pertenecen (lenguajes, matemáticas, arquitectura, ...).
• Sobre el personal de servicio, hay que conocer a qué sección están asignados
(biblioteca, decanato, secretaría, ...).
El ejercicio consiste, en primer lugar, en definir la jerarquía de clases de esta aplicación. A
continuación, debe programar las clases definidas en las que, además de los constructores,
hay que desarrollar los métodos correspondientes a las siguientes operaciones:
• Cambio del estado civil de una persona.
• Reasignación de despacho a un empleado.
• Matriculación de un estudiante en un nuevo curso.
• Cambio de departamento de un profesor.
• Traslado de sección de un empleado del personal de servicio.
• Imprimir toda la información de cada tipo de individuo. Incluya un programa de prueba
que instancie objetos de los distintos tipos y pruebe los métodos desarrollados.
 */
package SistemaGestiónFacultad;

import Entidades.Estudiante;
import Entidades.Persona;
import Entidades.PersonalDeServicio;
import Entidades.Profesor;
import Service.FacultadService;
import java.util.Scanner;

/**
 *
 * @author Elio
 */
public class SistemaFacultad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FacultadService fs = new FacultadService();

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int cant = 0;
        int opc;
        fs.crearPersonalDeServicio();
        fs.crearProfesores();
        fs.crearEstudiantes();
        
        System.out.println("SISTEMA DE GESTIÓN FACULTAD");
        System.out.println("############################");

        do {
            System.out.println("MENU");
            System.out.println("--------");
            System.out.println("1.- Mostrar Personal Servicio");
            System.out.println("2.- Mostrar Profesores");
            System.out.println("3.- Mostrar Alumnos");
            System.out.println("4.- Cambio de Estado Civil");
            System.out.println("5.- Reasignación de despacho");
            System.out.println("6.- Matriculación nueva");
            System.out.println("7.- Cambio de departamento");
            System.out.println("8.- Traslado de sección");
            System.out.println("9.- Salir");

            opc = leer.nextInt();

            switch (opc) {
                case 1:

                    for (Persona aux : fs.pasarLista()) {
                        if (aux instanceof PersonalDeServicio) {
                            System.out.println(aux);
                        }
                    }
                    break;
                case 2:
                    for (Persona aux : fs.pasarLista()) {
                        if (aux instanceof Profesor) {
                            System.out.println(aux);
                        }
                    }
                    break;
                case 3:
                    for (Persona aux : fs.pasarLista()) {
                        if (aux instanceof Estudiante) {
                            System.out.println(aux);
                        }
                    }
                    break;
                case 4:
                    fs.cambioDeEstadoCivil();
                    break;
                case 5:
                    fs.reasignacionDespacho();
                    break;
                case 6:
                    fs.matriculacionNueva();
                    break;
                case 7:
                    fs.CambioDeDepartamento();
                    break;
                case 8:
                    fs.trasladoDeSeccion();
                    break;
                case 9:
                    System.out.println("Gracias Por Utilizar el Sistema");
                    break;
            }

        } while (opc != 9);

    }
}
// falta crear un submenú para cada caso para evitar seleccionar una accion erronea
// para el tipo de persona(profesor, estudiante o personal de servicio)
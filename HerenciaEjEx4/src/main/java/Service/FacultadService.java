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
package Service;

import Entidades.Empleado;
import Entidades.Estudiante;
import Entidades.Persona;
import Entidades.PersonalDeServicio;
import Entidades.Profesor;
import Enums.Apellidos;
import Enums.Estado_Civil;
import Enums.Materias;
import Enums.Nombres;
import Enums.Sectores;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Elio
 */
public class FacultadService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Random nom = new Random();
    ArrayList<Persona> listaPersonas = new ArrayList();

    public void crearPersonalDeServicio() {

        for (int i = 0; i < 10; i++) {
            PersonalDeServicio pds = new PersonalDeServicio();
            pds.setApellido(apellido());
            pds.setNombre(nombre());
            pds.setDni(generarDni());
            pds.setEstadoCivil(estadoCivil());
            pds.setSeccion(SectoresPersonalServicios());
            pds.setAnioInc(anio());
            pds.setNumDesp(nom.nextInt(50) + 1);

            listaPersonas.add(pds);
        }
        System.out.println("");
    }

    public void crearProfesores() {

        for (int i = 0; i < 10; i++) {
            Profesor profes = new Profesor();
            profes.setApellido(apellido());
            profes.setNombre(nombre());
            profes.setDni(generarDni());
            profes.setEstadoCivil(estadoCivil());
            profes.setDepartamento(materia());
            profes.setAnioInc(anio());
            profes.setNumDesp(nom.nextInt(50) + 1);

            listaPersonas.add(profes);
        }
        System.out.println("");
    }

    public void crearEstudiantes() {

        for (int i = 0; i < 10; i++) {
            Estudiante alumno = new Estudiante();
            alumno.setApellido(apellido());
            alumno.setNombre(nombre());
            alumno.setDni(generarDni());
            alumno.setEstadoCivil(estadoCivil());
            alumno.setCursoMat(nom.nextInt(5) + 1);

            listaPersonas.add(alumno);
        }
        System.out.println("");
    }
    
    public ArrayList<Persona> pasarLista(){
        return listaPersonas;
    }

    public void mostrarLista() {

        for (Persona aux : listaPersonas) {
            System.out.println(aux);
        }
        System.out.println("");
    }

    public void cambioDeEstadoCivil() {
        System.out.print("Ingrese el DNI de la persona a cambiar: ");
        int dni = leer.nextInt();
        boolean ref = false;
        Persona pers = new Persona();

        for (Persona aux : listaPersonas) {
            if (aux.getDni() == dni) {
                System.out.println("El estado civil actual es " + aux.getEstadoCivil());
                System.out.println("");
                System.out.println("Estados Civiles");
                mostrarEstadoCivil();
                System.out.print("Ingrese el nuevo estado civil: ");
                int nuevoEstado = leer.nextInt();
                String estado = elegirEstadoCivil(nuevoEstado);
                aux.setEstadoCivil(estado);
                ref = true;
                pers = aux;
                break;
            }
        }
        if (!ref) {
            System.out.println("Ingresó un DNI incorrecto");
        } else {
            System.out.println("El estado cambio correctamente");
            System.out.println(pers);
        }
        System.out.println("");
    }
    
    public void reasignacionDespacho(){
    System.out.print("Ingrese el DNI de la persona a cambiar: ");
        int dni = leer.nextInt();
        boolean ref = false;
        Persona pers = new Persona();

        for (Persona aux : listaPersonas) {
            if(aux instanceof Empleado)
            if (aux.getDni() == dni) {
                System.out.println("El Despacho actual es " + ((Empleado) aux).getNumDesp());
                System.out.println("");

                System.out.println("Reasignando nuevo despacho..");
                 int numeroDespacho = (nom.nextInt(50) + 1);
                ((Empleado) aux).setNumDesp(numeroDespacho);
                ref = true;
                pers = aux;
                break;
            }
        }
        if (!ref) {
            System.out.println("Ingresó un DNI incorrecto");
        } else {
            System.out.println("El numero de despacho cambio correctamente");
            System.out.println(pers);
        }
        System.out.println("");
    
    
    
    }

    public void matriculacionNueva(){
    
    System.out.print("Ingrese el DNI de la persona a cambiar: ");
        int dni = leer.nextInt();
        boolean ref = false;
        Persona pers = new Persona();

        for (Persona aux : listaPersonas) {
            if(aux instanceof Estudiante)
            if (aux.getDni() == dni) {
                System.out.println("El Curso actual es " + ((Estudiante) aux).getCursoMat() + "°");
                System.out.println("");

                System.out.println("Reasignando nuevo Curso..");
                 int nuevaMatricula = (nom.nextInt(5) + 1);
                 if(nuevaMatricula == ((Estudiante) aux).getCursoMat()){
                  nuevaMatricula = (nom.nextInt(5) + 1);
                 }else{
                ((Estudiante) aux).setCursoMat(nuevaMatricula);
                ref = true;
                pers = aux;
                break;
                 }
            }
        }
        if (!ref) {
            System.out.println("Ingresó un DNI incorrecto");
        } else {
            System.out.println("El numero de Curso cambio correctamente");
            System.out.println(pers);
        }
        System.out.println("");
    
        }
    
    public void CambioDeDepartamento(){
    
    System.out.print("Ingrese el DNI de la persona a cambiar: ");
        int dni = leer.nextInt();
        boolean ref = false;
        Persona pers = new Persona();

        for (Persona aux : listaPersonas) {
            if(aux instanceof Profesor)
            if (aux.getDni() == dni) {
                System.out.println("El Departamento actual es " + ((Profesor) aux).getDepartamento());
                String departamento = ((Profesor) aux).getDepartamento();
                System.out.println("");

                System.out.println("Reasignando nuevo Departamento..");
                 String nuevoDepartamento = materia();
                 if(departamento.equalsIgnoreCase( nuevoDepartamento)){
                  nuevoDepartamento = materia();
                 }else{
                ((Profesor) aux).setDepartamento(nuevoDepartamento);
                ref = true;
                pers = aux;
                break;
                 }
            }
        }
        if (!ref) {
            System.out.println("Ingresó un DNI incorrecto");
        } else {
            System.out.println("El Departamento cambio correctamente");
            System.out.println(pers);
        }
        System.out.println("");
    
    }
    
    public void trasladoDeSeccion(){
    
    System.out.print("Ingrese el DNI de la persona a cambiar: ");
        int dni = leer.nextInt();
        boolean ref = false;
        Persona pers = new Persona();

        for (Persona aux : listaPersonas) {
            if(aux instanceof PersonalDeServicio)
            if (aux.getDni() == dni) {
                System.out.println("La sección actual es " + ((PersonalDeServicio) aux).getSeccion());
                String seccion = ((PersonalDeServicio) aux).getSeccion();
                System.out.println("");

                System.out.println("Reasignando nueva sección..");
                 String nuevaSeccion = SectoresPersonalServicios();
                 if(seccion.equalsIgnoreCase( nuevaSeccion)){
                  nuevaSeccion = SectoresPersonalServicios();
                 }else{
                ((PersonalDeServicio) aux).setSeccion(nuevaSeccion);
                ref = true;
                pers = aux;
                break;
                 }
            }
        }
        if (!ref) {
            System.out.println("Ingresó un DNI incorrecto");
        } else {
            System.out.println("La Reasignación fue exitosa ");
            System.out.println(pers);
        }
        System.out.println("");
    
    
    }
    
    // Servicios para crear por medio del random.
    public String nombre() {

        return Nombres.values()[nom.nextInt(Nombres.values().length)].name();
    }

    public String apellido() {

        return Apellidos.values()[nom.nextInt(Apellidos.values().length)].name();
    }

    public int generarDni() {
        int dni;
        do {
            dni = nom.nextInt(50000000);
        } while (dni < 15000000);
        return dni;
    }

    public String estadoCivil() {

        return Estado_Civil.values()[nom.nextInt(Estado_Civil.values().length)].name();
    }

    public String SectoresPersonalServicios() {

        return Sectores.values()[nom.nextInt(Sectores.values().length)].name();
    }

    public int anio() {
        int anio;
        do {
            anio = nom.nextInt(2023);
        } while (anio < 1985);

        return anio;
    }

    public String materia() {

        return Materias.values()[nom.nextInt(Materias.values().length)].name();
    }

    public void mostrarEstadoCivil() {

        for (int i = 0; i < Estado_Civil.values().length; i++) {
            System.out.println((i + 1) + ".- " + Estado_Civil.values()[i].name());
        }
    }

    public String elegirEstadoCivil(int a) {

        return Estado_Civil.values()[(a - 1)].name();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Estudiante;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Fran Perez
 */
public class EstudianteCont {

    public static void leerEstudiantes() {
        DAOEstudiante daoEst = new DAOEstudiante();
        ArrayList<Estudiante> estudiantes = daoEst.leerTodo();
        estudiantes.forEach(e -> {
            System.out.println(e.toString());
        });
    }

    public static void insertar() {
        Scanner sc = new Scanner(System.in);
        //Verificar datos
        System.out.println("Introduce el nombre");
        String nombre = sc.nextLine();
        System.out.println("Introduce la edad");
        int edad = sc.nextInt();
        DAOEstudiante daoEst = new DAOEstudiante();
        //Habría que comprobar que no estuviera repetido
        daoEst.insertar(new Estudiante(nombre, edad));
    }

    public static void actualizar() {
        leerEstudiantes();
        Scanner sc = new Scanner(System.in);
        //Verificar datos
        System.out.println("Introduce el nombre");
        String nombre = sc.nextLine();
        //Verificar que el usuario existe
        System.out.println("Introduce la edad");
        int edad = sc.nextInt();
        DAOEstudiante daoEst = new DAOEstudiante();
        //Habría que comprobar que no estuviera repetido
        daoEst.actualizar(new Estudiante(nombre, edad));
    }
    
    public static void borrar() {
        leerEstudiantes();
        Scanner sc = new Scanner(System.in);
        //Verificar datos
        //Verificar que el usuario existe
        System.out.println("Introduce el nombre");
        String nombre = sc.nextLine();
        DAOEstudiante daoEst = new DAOEstudiante();
        //Habría que comprobar que no estuviera repetido
        daoEst.borrar(new Estudiante(nombre));
    }

}

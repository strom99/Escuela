package Vista;

import Controlador.DAOEstudiante;
import java.util.Scanner;

/**
 *
 * @author Fran Perez
 */
public class Principal {
    
    

    /**
     * @param args the command line arguments
     */
    
    public static void menu(){
        System.out.println("1. Seleccionar todos los estudiante");
        System.out.println("2. Añadir un estudiante");
        System.out.println("3. Modificar un estudiante");
        System.out.println("4. Borrar un estudiante");
        System.out.println("Selecciona una opcion: ");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        boolean exit = false;
        do{
            menu();
            switch(sc.nextInt()){
                case 1: 
                    Controlador.EstudianteCont.leerEstudiantes();  
                    break;
                case 2: 
                    Controlador.EstudianteCont.insertar();
                    break;
                case 3: 
                    Controlador.EstudianteCont.actualizar();
                    break;
                case 4: 
                    Controlador.EstudianteCont.borrar();
                    break;
            }                    
        }while(!exit);    
    }
}
        
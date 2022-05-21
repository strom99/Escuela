package Controlador;

import static Controlador.Conexion.conectar;
import static Controlador.Conexion.desconectar;
import Modelo.Estudiante;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fran Perez
 */
public class DAOEstudiante {

    public ArrayList<Estudiante> leerTodo() {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        Connection conn = null;
        Statement instruccion = null;
        ResultSet rs = null;
        try {
            conn = conectar();
            instruccion = conn.createStatement();
            String select = "select * from colegio.estudiante";
            rs = instruccion.executeQuery(select);
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                //Generamos los objetos para poder manipularlos
                estudiantes.add(new Estudiante(nombre, edad));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                rs.close();
                instruccion.close();      
                desconectar(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }           
        }
        return estudiantes;
    }
    
    public int insertar(Estudiante e){
        Connection conn = null;
        PreparedStatement instruccion = null;
        int registros=0;
        conn = conectar();
        try {
            instruccion = conn.prepareStatement("INSERT INTO colegio.estudiante (nombre, edad) VALUES (?, ?)");
            instruccion.setString(1,e.getName());
            instruccion.setInt(2,e.getEdad());
            //cada vez que modificamos una base de datos llamamos a executeUpdate()
            registros = instruccion.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                instruccion.close();      
                desconectar(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }           
        }
        //Devolvemos la cantidad de registros afectados
        return registros;
    }
    
    
    public int actualizar(Estudiante e){
        Connection conn = null;
        PreparedStatement instruccion = null;
        int registros=0;
        conn = conectar();
        try {
            instruccion = conn.prepareStatement("UPDATE colegio.estudiante SET edad = ? WHERE (nombre = ?);");
            instruccion.setInt(1,e.getEdad());
            instruccion.setString(2,e.getName());
            //cada vez que modificamos una base de datos llamamos a executeUpdate()
            registros = instruccion.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                instruccion.close();      
                desconectar(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }           
        }
        //Devolvemos la cantidad de registros afectados
        return registros;
    }
    
    public int borrar(Estudiante e){
        Connection conn = null;
        PreparedStatement instruccion = null;
        int registros=0;
        conn = conectar();
        try {
            instruccion = conn.prepareStatement("DELETE FROM colegio.estudiante WHERE (nombre = ?);");
            instruccion.setString(1,e.getName());
            //cada vez que modificamos una base de datos llamamos a executeUpdate()
            registros = instruccion.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                instruccion.close();      
                desconectar(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }           
        }
        //Devolvemos la cantidad de registros afectados
        return registros;
    }
    
    
    
    
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fran Perez
 */
public class Conexion {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/colegio?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    

    public static Connection conectar() {
        Connection conn = null;
        try {
            //Esta línea no es necesaria, excepto en algunas aplicaciones WEB
            //En aplicaciones locales como esta no sería necesaria
            //Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//        } catch (ClassNotFoundException ex) {
//           ex.printStackTrace(System.out);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return conn;
    }

    public static void desconectar(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }  
}

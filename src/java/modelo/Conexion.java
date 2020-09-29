/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Djauregui
 */
public class Conexion {
    public Connection conexionBD;
    //jdbc:mysql://localhost:3306/db_P2_DW_database
    private final String puerto= "3306";
    private final String bd= "db_P2_DW_database";
    private final String urlConexion = String.format("jdbc:mysql://localhost:%s/%s?serverTimezone=UTC",puerto, bd);
    private final String usuario = "usr_admin";
    private final String contra = "admin";
    private final String jdbc ="com.mysql.cj.jdbc.Driver";
    
    public void abrir_conexion(){
            try{
                Class.forName(jdbc);
                conexionBD = DriverManager.getConnection(urlConexion,usuario,contra);               
               // System.out.println("Conexion Exitosa");
            }catch(ClassNotFoundException | SQLException ex){
                    System.out.println("Error: " + ex.getMessage());
            }
    }
    
    public void cerrar_conexion(){
        try{
            conexionBD.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    
    }
}

package com.samuel.bussinestask.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private Connection con;    
    private final String user="root";
    private final String pass="";
    private final String url="jdbc:mysql://localhost:3306/bussin_task?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    
    public ConnectionDB(){
        this.con = null;
    }
    
    /**
     * Permite la conexion con la Base de datos Msyql
     * @return 
     */
    public Connection getConnection(){
        try{            
            this.con = DriverManager.getConnection(url,user,pass);
            if(this.con!=null){
                System.out.println("Conexion OK");
            }       
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
        return this.con;
    }
    
    /**
     * Cierra la conexion para que no mantenga abierta
     */
    public void closeConnection(){        
        try{            
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexión cerrada correctamente");
            }
        }catch(SQLException e){
            System.out.println("EEROR AL DESCONECTAR "+e.getMessage());
        }
    }                     
    
}
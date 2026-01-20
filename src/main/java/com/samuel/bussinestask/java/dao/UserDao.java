package com.samuel.bussinestask.java.dao;

import com.samuel.bussinestask.java.dao.impl.IUserDao;
import com.samuel.bussinestask.java.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements IUserDao {
    private final ConnectionDB connection;
    private PreparedStatement PS;
    private ResultSet RS;
    
    private void clearPreparedAndResultAndCloseConnection(){
        PS=null;
        RS=null;
        this.connection.closeConnection();
    }
    
    public UserDao(){
        this.connection = new ConnectionDB();
    }

    @Override
    public List<User> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertar(User usuario) {
        String query="INSERT INTO users(username, password, email, role, created_at)VALUES(?,?,?,?,?)";
        try{
            PS = this.connection.getConnection().prepareStatement(query);
            PS.setString(1,usuario.getUserName());
            PS.setString(2,usuario.getPassword());
            PS.setString(3,usuario.getEmail());
            PS.setString(4,usuario.getRole().name());
            PS.setDate(5,usuario.getCreateAt());            
            
            if(PS.executeUpdate()>0){
                System.out.println("Usuario registrado");
            }
        }catch(SQLException e){
            System.err.println("ERROR AL CREAR USUARIOS "+e);
        }finally{
            clearPreparedAndResultAndCloseConnection();
        }        
    }

    @Override
    public User buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(User usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}

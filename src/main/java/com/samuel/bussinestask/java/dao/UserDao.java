package com.samuel.bussinestask.java.dao;

import com.samuel.bussinestask.java.dao.impl.IUserDao;
import com.samuel.bussinestask.java.model.Role;
import com.samuel.bussinestask.java.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String query = "SELECT * FROM users";
        List<User> usuarios = new ArrayList<>();
        try {
            PS = connection.getConnection().prepareStatement(query);
            RS = PS.executeQuery();
            while (RS.next()) {
                User usuario = new User(
                    RS.getInt("id"),
                    RS.getString("username"),
                    RS.getString("password"),
                    RS.getString("email"),
                    Role.valueOf(RS.getString("role")),
                    RS.getBoolean("authentication"),
                    RS.getBoolean("enable"),
                    RS.getBoolean("completed"),
                    RS.getDate("created_at"),
                    RS.getDate("updated_at")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.err.println("ERROR AL LISTAR: " + e.getMessage());
        } finally {
            clearPreparedAndResultAndCloseConnection();
        }
        return usuarios;
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
        String query = "SELECT * FROM users WHERE id = ?";
        User usuario = null;
        try {
            PS = connection.getConnection().prepareStatement(query);
            PS.setInt(1, id);

            RS = PS.executeQuery();
            if (RS.next()) {
                usuario = new User(
                    RS.getInt("id"),
                    RS.getString("username"),
                    RS.getString("password"),
                    RS.getString("email"),
                    Role.valueOf(RS.getString("role")),
                    RS.getBoolean("authentication"),
                    RS.getBoolean("enable"),
                    RS.getBoolean("completed"),
                    RS.getDate("created_at"),
                    RS.getDate("updated_at")
                );
            }
        } catch (SQLException e) {
            System.err.println("ERROR AL BUSCAR POR ID: " + e.getMessage());
        } finally {
            clearPreparedAndResultAndCloseConnection();
        }
        return usuario;
    }


    @Override
    public void actualizar(User usuario) {
        String query = """
            UPDATE users
            SET username = ?,
                password = ?,
                email = ?,
                role = ?,
                authentication = ?,
                enable = ?,
                completed = ?,
                updated_at = ?
            WHERE id = ?
        """;

        try {
            PS = connection.getConnection().prepareStatement(query);

            PS.setString(1, usuario.getUserName());
            PS.setString(2, usuario.getPassword());
            PS.setString(3, usuario.getEmail());
            PS.setString(4, usuario.getRole().name());
            PS.setBoolean(5, usuario.isAuthentication());
            PS.setBoolean(6, usuario.isEnable());
            PS.setBoolean(7, usuario.isCompleted());
            PS.setDate(8, new java.sql.Date(System.currentTimeMillis()));
            PS.setInt(9, usuario.getId());

            int rows = PS.executeUpdate();

            if (rows > 0) {
                System.out.println("Usuario actualizado correctamente");
            } else {
                System.out.println("No se encontró usuario con id=" + usuario.getId());
            }

        } catch (SQLException e) {
            System.err.println("ERROR EN actualizar(): " + e.getMessage());

        } finally {
            clearPreparedAndResultAndCloseConnection();
        }
    }


    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        try {
            PS = connection.getConnection().prepareStatement(query);
            PS.setInt(1, id);
            int rows = PS.executeUpdate();
            if (rows > 0) {
                System.out.println("Usuario eliminado correctamente");
            } else {
                System.out.println("No existe usuario con id=" + id);
            }
        } catch (SQLException e) {
            System.err.println("ERROR EN eliminar(): " + e.getMessage());

        } finally {
            clearPreparedAndResultAndCloseConnection();
        }
    }
           
}

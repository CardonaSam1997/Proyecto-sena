package com.samuel.bussinestask.java.dao.impl;
import com.samuel.bussinestask.java.model.User;
import java.util.List;

public interface IUserDao {
    
    List<User> listar();
    
    void insertar(User usuario);
    
    User buscar(int id);
    
    void actualizar(User usuario);
    
    void eliminar(int id);
}
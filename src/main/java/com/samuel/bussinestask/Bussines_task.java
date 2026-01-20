package com.samuel.bussinestask;

import com.samuel.bussinestask.java.dao.ConnectionDB;
import com.samuel.bussinestask.java.dao.UserDao;
import com.samuel.bussinestask.java.model.Role;
import com.samuel.bussinestask.java.model.User;

public class Bussines_task {

    public static void main(String[] args) {
        ConnectionDB c = new ConnectionDB();
        c.getConnection();
        
        UserDao crud = new UserDao();
        User usuario = new User("pepe","1123","pepe@gmail.com",Role.ADMIN);
        
        crud.insertar(usuario);
        
    }
}

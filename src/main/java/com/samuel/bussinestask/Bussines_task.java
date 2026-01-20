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
        
        //System.out.println("\n INSERTAR USUARIO\n");
        //crud.insertar(usuario);
        System.out.println("\n LISTAR TODOS LOS USUARIOS\n");
        System.out.println(crud.listar());
        System.out.println("\n LISTAR USUARIO POR ID\n");
        System.out.println(crud.buscar(1));
        System.out.println("\n ELIMINAR USUARIO POR ID\n");
        crud.eliminar(7);
        
        User miguel = new User(6,"miguel","1123","miguel@gmail.com",Role.ADMIN);        
        crud.actualizar(miguel);
        
    }
}

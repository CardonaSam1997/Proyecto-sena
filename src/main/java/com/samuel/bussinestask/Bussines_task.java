package com.samuel.bussinestask;

import com.samuel.bussinestask.java.dao.ConnectionDB;

public class Bussines_task {

    public static void main(String[] args) {
        ConnectionDB c = new ConnectionDB();
        c.getConnection();
    }
}

package org.example.schoolmanager.IDBConfig;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseDB {

    static  String host = "localhost";
    static String port = "3306";
    static String user = "root";
    static String password = "";
    static String database = "school_manager";
    static String URL = "jdbc:mysql://"+host+":"+port+"/"+database;

    public static Connection connectDB() {
        try{
            return DriverManager.getConnection(URL, user, password);
        } catch (Exception e){
            return null;
        }
    }

}

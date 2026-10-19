package com.mycompany.programa_de_plataforma_adso.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    
    private static final String URL = "jdbc:mysql://localhost:3306/plataforma_adso";
    private static final String USER = "root"; 
    private static final String PASSWORD = "juanse1234"; 

    public static Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conexion;
    }
}

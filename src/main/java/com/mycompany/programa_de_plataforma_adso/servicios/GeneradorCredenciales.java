package com.mycompany.programa_de_plataforma_adso.servicios;

import java.security.SecureRandom;

public class GeneradorCredenciales {
    
    private static final String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMEROS = "0123456789";
    private static final String ESPECIALES = "!@#$%&*_=+-/";
    
    public static String generarPassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        

        password.append(MAYUSCULAS.charAt(random.nextInt(MAYUSCULAS.length())));
        password.append(MINUSCULAS.charAt(random.nextInt(MINUSCULAS.length())));
        password.append(NUMEROS.charAt(random.nextInt(NUMEROS.length())));
        password.append(ESPECIALES.charAt(random.nextInt(ESPECIALES.length())));
        
        String todosLosCaracteres = MAYUSCULAS + MINUSCULAS + NUMEROS + ESPECIALES;
        for (int i = 4; i < 8; i++) {
            password.append(todosLosCaracteres.charAt(random.nextInt(todosLosCaracteres.length())));
        }

        return password.toString();
    }
    

    public static String generarToken() {
        SecureRandom random = new SecureRandom();
        StringBuilder token = new StringBuilder();
        token.append(MAYUSCULAS.charAt(random.nextInt(MAYUSCULAS.length())));
        token.append(MAYUSCULAS.charAt(random.nextInt(MAYUSCULAS.length())));
        token.append(NUMEROS.charAt(random.nextInt(NUMEROS.length())));
        return token.toString();
    }
}
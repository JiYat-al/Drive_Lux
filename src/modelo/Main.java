/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.File;

/**
 *
 * @author jibsa
 */
public class Main {
    public static void main(String[] args) {
        // Ruta del archivo que deseas verificar
        String filePath = "/pdf/Acceso_1.pdf";
        
        // Crear un objeto File con la ruta proporcionada
        File file = new File(filePath);
        
        // Imprimir la ruta absoluta del archivo
        System.out.println("Ruta absoluta del archivo: " + file.getAbsolutePath());
        
        // Verificar si el archivo existe
        if (file.exists()) {
            System.out.println("El archivo existe.");
        } else {
            System.out.println("El archivo no existe. Verifica la ruta.");
        }
    }
   
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Base64;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author jibsa
 */
public class Utilidades {
    
    String LLAVE = "admin093";
    
        public static boolean validarCorreo (String correo){
        boolean validacion = false;
        String correcion = correo.toLowerCase();
        
        if(correcion.endsWith("@gmail.com"))
            validacion = true;
        else if (correcion.endsWith("@net.com"))
            validacion = true;
        else if (correcion.endsWith("@yahoo.com"))
            validacion = true;
        else if (correcion.endsWith("@itoaxaca.mx"))
            validacion = true;
        else if (correcion.endsWith("@hotmail.com"))
            validacion = true;
        else if (correcion.endsWith("@outlok.com"))
            validacion = true;
        
        return validacion;
    }
        
    // Clave de encriptación / desencriptación
    public SecretKeySpec CrearCalve(String llave) {
        try {
            byte[] cadena = llave.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(cadena, "AES");
            return secretKeySpec;
        } catch (Exception e) {
            return null;
        }

    }

    // Encriptar
    public String Encriptar(String encriptar) {
     
        try {
        SecretKeySpec secretKeySpec = CrearCalve(LLAVE);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            
            byte [] cadena = encriptar.getBytes("UTF-8");
            byte [] encriptada = cipher.doFinal(cadena);
            String cadena_encriptada = Base64.getEncoder().encodeToString(encriptada);
            return cadena_encriptada;
            
            
            
        } catch (Exception e) {
            return "";
        }
    }

    // Des-encriptación
     public String Desencriptar(String desencriptar) {
     
        try {
            SecretKeySpec secretKeySpec = CrearCalve(LLAVE);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            
            byte [] cadena = Base64.getDecoder().decode(desencriptar);
            byte [] desencriptacioon = cipher.doFinal(cadena);
            String cadena_desencriptada = new String(desencriptacioon);
            return cadena_desencriptada;
            
        } catch (Exception e) {
            return "";
        }
    }
    
}

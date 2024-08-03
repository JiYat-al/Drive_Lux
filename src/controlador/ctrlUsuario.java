package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Utilidades;
import java.sql.PreparedStatement;

public class ctrlUsuario {

    // Método para iniciar sesión
    public boolean loginUser(String email, String password) {

        boolean result = false;
        Connection cn = Conexion.conectar();
        Utilidades utilidad = new Utilidades();
        String sql = "SELECT password FROM employees WHERE email = ?";
        String passEncriptado = null;

        try (PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                passEncriptado = rs.getString("password");
                if (password.equals(utilidad.Desencriptar(passEncriptado))) {
                    result = true;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión");
        }

        return result;
    }
}

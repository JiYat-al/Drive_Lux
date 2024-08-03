/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Customer;

/**
 *
 * @author jibsa
 */
public class ClientesController {

        public void createCustomer(Customer cliente) {
            String query = "INSERT INTO customers (customer_name, customer_lastnames, customer_phone, customer_email, customer_rfc) VALUES (?, ?, ?, ?, ?);";
            try (Connection cn = Conexion.conectar();
                 PreparedStatement pstmt = cn.prepareStatement(query)) {
                pstmt.setString(1, cliente.getName());
                pstmt.setString(2, cliente.getLastName());
                pstmt.setString(3,cliente.getPhone());
                pstmt.setString(4, cliente.getEmail());
                pstmt.setString(5,cliente.getRFC());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        
            // Método para obtener todos los empleados
        public List<Customer>  getAllCustomers() {
            String query = "SELECT * FROM customers";
            List<Customer> clientes = new ArrayList<>();

            try (Connection cn = Conexion.conectar();
                 PreparedStatement pstmt = cn.prepareStatement(query);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Customer cliente = new Customer(
                            rs.getInt("customer_id"),
                            rs.getString("customer_name"),
                            rs.getString("customer_lastnames"),
                            rs.getString("customer_phone"),
                            rs.getString("customer_email"),
                            rs.getString("customer_rfc")
                    );
                    clientes.add(cliente);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return clientes;
        }
        
        public void updateCustomer(Customer cliente) {
        String query = "UPDATE customers SET customer_name = ?, customer_lastnames = ?, customer_phone = ?, customer_email = ?, customer_rfc = ? WHERE customer_id = ?";

        try (Connection cn = Conexion.conectar();
             PreparedStatement pstmt = cn.prepareStatement(query)) {
            pstmt.setString(1, cliente.getName());
            pstmt.setString(2, cliente.getLastName());
            pstmt.setString(3, cliente.getPhone());
            pstmt.setString(4, cliente.getEmail());
            pstmt.setString(5, cliente.getRFC());
            pstmt.setInt(6, cliente.getIdCustomer());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
         // Método para eliminar un coche por su número de serie
        public void deleteCustomer(int id_customer) {
            String query = "DELETE FROM customers WHERE customer_id = ?";

            try (Connection cn = Conexion.conectar();
                 PreparedStatement pstmt = cn.prepareStatement(query)) {
                 pstmt.setInt(1, id_customer);
                 pstmt.executeUpdate();
             } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
}

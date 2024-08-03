/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.security.SecureRandom;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Employee;
import modelo.Utilidades;

/**
 *
 * @author jibsa
 */
public class EmpleadosController {
 
        public void createEmployee(Employee empleado) {
            Utilidades util = new Utilidades();
            String password = util.Encriptar(generatePassword());
            String query = "INSERT INTO employees (name, first_lastname, second_lastname, address, email, password, rol) VALUES (?, ?, ?, ?, ?, ?, ?::rol);";
            try (Connection cn = Conexion.conectar();
                 PreparedStatement pstmt = cn.prepareStatement(query)) {
                pstmt.setString(1, empleado.getName());
                pstmt.setString(2, empleado.getFirstLastName());
                pstmt.setString(3, empleado.getSecondLastName());
                pstmt.setString(4, empleado.getAddress());
                pstmt.setString(5, empleado.getEmail());
                pstmt.setString(6, password);
                pstmt.setString(7, empleado.getRol());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        public String getRolByEmail(String email)  {
            String query = "select rol from employees where email = ?";
                        String rol = null;
                    try (Connection cn = Conexion.conectar();
                    PreparedStatement pstmt = cn.prepareStatement(query)){
                           pstmt.setString(1, email);
                                ResultSet rs = pstmt.executeQuery();

                                if (rs.next()) {
                                    rol = rs.getString("rol");
                                }
                    } catch (SQLException e) {
                       e.printStackTrace();
                    }
                    return rol;
        }
        
                public int getIdByEmail(String email)  {
            String query = "SELECT id_employee FROM employees WHERE email = ?";
                        int id = 0;
                    try (Connection cn = Conexion.conectar();
                    PreparedStatement pstmt = cn.prepareStatement(query)){
                           pstmt.setString(1, email);
                                ResultSet rs = pstmt.executeQuery();

                                if (rs.next()) {
                                    id = rs.getInt("id_employee");
                                }
                    } catch (SQLException e) {
                       e.printStackTrace();
                    }
                    return id;
        }

        
            // Método para obtener todos los empleados
        public List<Employee>  getAllEmployees() {
            String query = "SELECT * FROM employees";
            List<Employee> empleados = new ArrayList<>();

            try (Connection cn = Conexion.conectar();
                 PreparedStatement pstmt = cn.prepareStatement(query);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Employee empleado = new Employee(
                            rs.getInt("id_employee"),
                            rs.getString("name"),
                            rs.getString("first_lastname"),
                            rs.getString("second_lastname"),
                            rs.getString("address"),
                            rs.getString("email"),
                            rs.getString("rol")
                    );
                    empleados.add(empleado);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return empleados;
        }
        
        public void updateCar(Employee emp) {
            String query = "UPDATE employees SET name = ?, first_lastname = ?, second_lastname = ?, address = ?, email = ?, rol = ?::rol WHERE id_employee = ?";

            try (Connection cn = Conexion.conectar();
                 PreparedStatement pstmt = cn.prepareStatement(query)) {
                pstmt.setString(1, emp.getName());
                pstmt.setString(2, emp.getFirstLastName());
                pstmt.setString(3, emp.getSecondLastName());
                pstmt.setString(4, emp.getAddress());
                pstmt.setString(5, emp.getEmail());
                pstmt.setString(6, emp.getRol());
                pstmt.setInt(7,emp.getIdEmployee());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            
        private String generatePassword() {
            String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}|;:'\",.<>?/";
            int PASSWORD_LENGTH = 8; 

            SecureRandom random = new SecureRandom();
            StringBuilder password = new StringBuilder(PASSWORD_LENGTH);

            for (int i = 0; i < PASSWORD_LENGTH; i++) {
                int index = random.nextInt(CHARACTERS.length());
                password.append(CHARACTERS.charAt(index));
            }

            return password.toString();
        }
        
         // Método para eliminar un coche por su número de serie
        public void deleteEmp(int id_employee) {
            String query = "DELETE FROM employees WHERE id_employee = ?";

            try (Connection cn = Conexion.conectar();
                 PreparedStatement pstmt = cn.prepareStatement(query)) {
                 pstmt.setInt(1, id_employee);
                 pstmt.executeUpdate();
             } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        public int getLastEmployeeId() {
        int lastEmployeeId = -1; // Valor predeterminado en caso de que no se encuentre ninguna venta
        String query = "SELECT id_employee FROM employees ORDER BY id_employee DESC LIMIT 1";

        try (Connection cn = Conexion.conectar();
            PreparedStatement pstmt = cn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                lastEmployeeId = rs.getInt("id_employee");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lastEmployeeId;
    }
    
        public String getPasswordById(int id_employee) {
        String password = null;
        String query = "SELECT password FROM employees WHERE id_employee = ?";
        try (Connection cn = Conexion.conectar();
                 PreparedStatement pstmt = cn.prepareStatement(query)) {
                 pstmt.setInt(1, id_employee);
                 
                 ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                password = rs.getString("password");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return password;
    }
    
}

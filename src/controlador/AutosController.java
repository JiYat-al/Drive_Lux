package controlador;

import conexion.Conexion;
import java.security.SecureRandom;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cars;

public class AutosController {
   
    // Método para crear un nuevo coche
    public void createCar(Cars car) {
        String query = "INSERT INTO cars (num_serie, id_model , year, price, color) VALUES (?, ?, ?, ?, ?)";
        try (Connection cn = Conexion.conectar();
            PreparedStatement pstmt = cn.prepareStatement(query)) {
            pstmt.setString(1, generateSerialNumber());
            pstmt.setInt(2, car.getId_model());
            pstmt.setInt(3, car.getYear());
            pstmt.setDouble(4, car.getPrice());
            pstmt.setString(5, car.getColor());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void cambiarIsSold(String numSerie){
        String query = "UPDATE cars SET is_sold = 'true' WHERE num_serie = ?";
        try (Connection cn = Conexion.conectar();
             PreparedStatement pstmt = cn.prepareStatement(query)) {
            pstmt.setString(1, numSerie);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
        public void cambiarIdSale(int idSale, String numSerie){
        String query = "UPDATE cars SET id_sale = ? WHERE num_serie = ?;";
        try (Connection cn = Conexion.conectar();
             PreparedStatement pstmt = cn.prepareStatement(query)) {
            pstmt.setInt(1, idSale);
            pstmt.setString(2, numSerie);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
        // Método para generar un número de serie
    private static String generateSerialNumber() {
        int length = 10;
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder serialNumber = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            serialNumber.append(CHARACTERS.charAt(index));
        }

        return serialNumber.toString();
    }

    // Método para obtener un coche por su número de serie
    public Cars getCarByNumSerie(String numSerie) {
        String query = "SELECT * FROM cars WHERE num_serie = ?";
        Cars car = null;

        try (Connection cn = Conexion.conectar();
             PreparedStatement pstmt = cn.prepareStatement(query)) {
            pstmt.setString(1, numSerie);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                car = new Cars(
                        rs.getString("num_serie"),
                        rs.getInt("id_model"),
                        rs.getInt("year"),
                        rs.getDouble("price"),
                        rs.getString("color")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    // Método para obtener todos los coches
    public List<Cars> getAllCarsNotSoldl() {
        String query = "SELECT * FROM cars WHERE is_sold = 'false'";
        List<Cars> cars = new ArrayList<>();

        try (Connection cn = Conexion.conectar();
             PreparedStatement pstmt = cn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Cars car = new Cars(
                        rs.getString("num_serie"),
                        rs.getInt("id_model"),
                        rs.getInt("year"),
                        rs.getDouble("price"),
                        rs.getString("color")
                );
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    // Método para actualizar un coche
    public void updateCar(Cars car) {
        String query = "UPDATE cars SET id_model = ?, year = ?, price = ?, color = ? WHERE num_serie = ?";

        try (Connection cn = Conexion.conectar();
             PreparedStatement pstmt = cn.prepareStatement(query)) {
            pstmt.setInt(1, car.getId_model());
            pstmt.setInt(2, car.getYear());
            pstmt.setDouble(3, car.getPrice());
            pstmt.setString(4, car.getColor());
            pstmt.setString(5, car.getNum_serie());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un coche por su número de serie
    public void deleteCar(String numSerie) {
        String query = "DELETE FROM cars WHERE num_serie = ?";

        try (Connection cn = Conexion.conectar();
             PreparedStatement pstmt = cn.prepareStatement(query)) {
            pstmt.setString(1, numSerie);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

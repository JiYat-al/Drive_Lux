package controlador;

import conexion.Conexion;
import modelo.Sale;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesController {

    public void createSale(Sale sale){
        
        String query = "INSERT INTO sales (customer_id, employee_id, sale_date, sale_total) VALUES (?, ?, ?, ?)";
        
        try (Connection cn = Conexion.conectar();
            PreparedStatement pstmt = cn.prepareStatement(query)) {
            pstmt.setInt(1, (int) sale.getCustomerId());
            pstmt.setInt(2, (int) sale.getEmployeeId());
            pstmt.setDate(3, sale.getSaleDate());
            pstmt.setDouble(4, sale.getSaleTotal());
            
              pstmt.executeUpdate(); // Ejecutar la consulta de inserción
              
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
        public List<Sale> getAllSale() {
        String query = "SELECT * FROM sales";
        List<Sale> sales = new ArrayList<>();

        try (Connection cn = Conexion.conectar();
             PreparedStatement pstmt = cn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Sale sale = new Sale(
                        rs.getInt("sale_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("employee_id"),
                        rs.getDate("sale_date"),
                        rs.getDouble("sale_total")
                );
                sales.add(sale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sales;
    }
        
        public int getLastSaleId() {
        int lastSaleId = -1; // Valor predeterminado en caso de que no se encuentre ninguna venta
        String query = "SELECT sale_id FROM sales ORDER BY sale_id DESC LIMIT 1";

        try (Connection cn = Conexion.conectar();
            PreparedStatement pstmt = cn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                lastSaleId = rs.getInt("sale_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lastSaleId;
    }
}
/*public long addSale(Sale sale) throws SQLException {
    String query = "INSERT INTO sales (customer_id, employee_id, sale_date, sale_total) VALUES (?, ?, ?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
        stmt.setLong(1, sale.getCustomerId());
        stmt.setLong(2, sale.getEmployeeId());
        stmt.setDate(3, new java.sql.Date(sale.getSaleDate().getTime())); // Convert java.util.Date to java.sql.Date
        stmt.setDouble(4, sale.getSaleTotal());
        
        // Ejecutar la actualización
        int affectedRows = stmt.executeUpdate();
        
        // Verificar si se insertó alguna fila
        if (affectedRows > 0) {
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    // Retornar el ID de la venta recién insertada
                    return generatedKeys.getLong(1);
                } else {
                    throw new SQLException("No se pudo obtener el ID de la venta.");
                }
            }
        } else {
            throw new SQLException("No se realizó ninguna actualización.");
        }
    } catch (SQLException e) {
        System.err.println("Error adding sale: " + e.getMessage());
        throw e; // Opcionalmente, vuelve a lanzar la excepción después de registrar
    }
}
*/


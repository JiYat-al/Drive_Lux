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
import modelo.Brand;

/**
 *
 * @author jibsa
 */
public class MarcasController {

    public void createBrand(Brand brand) {
        String query = "INSERT INTO brand (name, country_origen) VALUES (?, ?)";
        try (Connection cn = Conexion.conectar();
            PreparedStatement pstmt = cn.prepareStatement(query)) {
            pstmt.setString(1, brand.getName());
            pstmt.setString(2, brand.getCountry_origen());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Brand> getAllBrands() {
        String query = "SELECT * FROM brand";
        List<Brand> brands = new ArrayList<>();

        try (Connection cn = Conexion.conectar();
             PreparedStatement pstmt = cn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Brand brand = new Brand(
                        rs.getInt("id_brand"),
                        rs.getString("name"),
                        rs.getString("country_origen")
                );
                brands.add(brand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brands;
    }

    public void updateBrand(Brand brand) {
        String query = "UPDATE brand SET name = ?, country_origen = ? WHERE id_brand = ?";

        try (Connection cn = Conexion.conectar();
             PreparedStatement pstmt = cn.prepareStatement(query)) {
            pstmt.setString(1, brand.getName());
            pstmt.setString(2, brand.getCountry_origen());
            pstmt.setInt(3, brand.getId_brand());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBrand(int id_brand) {
        String query = "DELETE FROM brand WHERE id_brand = ?";

        try (Connection cn = Conexion.conectar();
             PreparedStatement pstmt = cn.prepareStatement(query)) {
            pstmt.setInt(1, id_brand);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}

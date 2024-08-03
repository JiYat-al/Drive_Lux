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
import modelo.Model;

/**
 *
 * @author jibsa
 */
public class ModeloController {
    
        public void createModel(Model model) {
        String query = "INSERT INTO models (name_model, id_brand) VALUES (?, ?)";
        try (Connection cn = Conexion.conectar();
            PreparedStatement pstmt = cn.prepareStatement(query)) {
            pstmt.setString(1, model.getName());
            pstmt.setInt(2, model.getId_brad());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
        public int buscarPorNombreMarca(String name){
            String query = "SELECT id_brand from brand where name = ?";
            int id = 0;
                    try (Connection cn = Conexion.conectar();
                    PreparedStatement pstmt = cn.prepareStatement(query)){
                                pstmt.setString(1, name);
                                ResultSet rs = pstmt.executeQuery();

                                if (rs.next()) {
                                    id = rs.getInt("id_brand");
                                }
                    } catch (SQLException e) {
                       e.printStackTrace();
                    }
                    
                    return id;
        }
        
                 public String getNamebyId(int id){
                  String name = null;
            String query = "SELECT name_model from models where id_model = ?";
                    try (Connection cn = Conexion.conectar();
                    PreparedStatement pstmt = cn.prepareStatement(query)){
                                pstmt.setInt(1, id);
                                ResultSet rs = pstmt.executeQuery();

                                if (rs.next()) {
                                    name = rs.getString("name_model");
                                }
                    } catch (SQLException e) {
                       e.printStackTrace();
                    }
                    
                    return name;
        }
        
        
         public String buscarNombrePorId(int id){
                  String name = null;
            String query = "SELECT name from brand where id_brand = ?";
                    try (Connection cn = Conexion.conectar();
                    PreparedStatement pstmt = cn.prepareStatement(query)){
                                pstmt.setInt(1, id);
                                ResultSet rs = pstmt.executeQuery();

                                if (rs.next()) {
                                    name = rs.getString("name");
                                }
                    } catch (SQLException e) {
                       e.printStackTrace();
                    }
                    
                    return name;
        }
        
        public List<Model> getAllModels() {
        String query = "SELECT models.id_model, models.name_model, brand.name FROM models NATURAL JOIN brand ";
        List<Model> models = new ArrayList<>();

        try (Connection cn = Conexion.conectar();
             PreparedStatement pstmt = cn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Model model = new Model(
                        rs.getInt("id_model"),
                        rs.getString("name_model"),
                        rs.getString("name")
                );
                models.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return models;
    }

    // Método para actualizar un coche
    public void updateModel(Model model) {
        String query = "UPDATE models SET name_model = ?, id_brand = ? WHERE id_model = ?";

        try (Connection cn = Conexion.conectar();
            PreparedStatement pstmt = cn.prepareStatement(query)) {
            pstmt.setString(1, model.getName());
            pstmt.setInt(2, model.getId_brad());
            pstmt.setInt(3, model.getId_model());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un coche por su número de serie
    public void deleteModel(int id_model) {
        String query = "DELETE FROM models WHERE id_model = ?";

        try (Connection cn = Conexion.conectar();
             PreparedStatement pstmt = cn.prepareStatement(query)) {
            pstmt.setInt(1, id_model);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public List<Model> getModelsByBrand(int brandId) {
        List<Model> models = new ArrayList<>();
        String sql = "SELECT * FROM models WHERE id_brand = ?";

        try (Connection cn = Conexion.conectar();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, brandId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Model model = new Model(
                        rs.getInt("id_model"),
                        rs.getString("name_model"),
                        rs.getInt("id_brand")
                    );
                    models.add(model);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return models;
    }
        
       public String getNameBrand(int id_model) {
        String query = "SELECT brand.name FROM models NATURAL JOIN brand where id_model = ?";
        String name = null;
        try (Connection cn = Conexion.conectar();
             PreparedStatement pstmt = cn.prepareStatement(query);) {
            pstmt.setInt(1, id_model);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                name = rs.getString("name");
            }
         
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return name;
        
    }
}

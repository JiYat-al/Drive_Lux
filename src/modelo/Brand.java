/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jibsa
 */
public class Brand {
    
    private int id_brand;
    private String name;
    private String country_origen;
    
    public Brand(int id, String name, String country_origen){
        id_brand = id;
        this.name = name;
        this.country_origen = country_origen;
    }
    
    public Brand( String name, String country_origen){
        id_brand = 0;
        this.name = name;
        this.country_origen = country_origen;
    }

    public int getId_brand() {
        return id_brand;
    }

    public void setId_brand(int id_brand) {
        this.id_brand = id_brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry_origen() {
        return country_origen;
    }

    public void setCountry_origin(String country_origen) {
        this.country_origen = country_origen;
    }
    
     @Override
     public String toString(){
         return this.name;
     }
    
}

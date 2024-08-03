/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jibsa
 */
public class Model {
    private int id_model;
    private String name;
    private int id_brad;
    private String brad;
    
    public Model(String name, int id_brad){
        this.name = name;
        this.id_brad = id_brad;
    }
       
    public Model(int id_model, String name, int id_brad){
        this.id_model = id_model;
        this.name = name;
        this.id_brad = id_brad;
    }
    
    public Model(int id_model, String name, String brad){
        this.id_model = id_model;
        this.name = name;
        this.brad = brad;
    }
    

    public int getId_model() {
        return id_model;
    }

    public void setId_model(int id_model) {
        this.id_model = id_model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_brad() {
        return id_brad;
    }

    public void setId_brad(int id_brad) {
        this.id_brad = id_brad;
    }
    
    public String getBrad(){
        return brad;
    }
    
    public void setBrad(String brad){
        this.brad = brad;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}

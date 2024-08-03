/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jibsa
 */
public class Customer {
    
    int idCustomer;
    String name;
    String lastName;
    String phone;
    String email;
    String rfc;
    
    public Customer(){
        idCustomer = 0;
        name = "";
        lastName = "";
        phone = "";
        email = "";
        rfc = "";
    }
    
    public Customer( String name, String lastName, String phone, String email, String curp){
        idCustomer = 0;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.rfc = curp;
    }
    
    public Customer( int id,String name, String lastName, String phone, String email, String curp){
        idCustomer = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.rfc = curp;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRFC() {
        return rfc;
    }

    public void setRFC(String rfc) {
        this.rfc = rfc;
    }
    
    @Override
    public String toString(){
        return this.rfc;
    }
    
}

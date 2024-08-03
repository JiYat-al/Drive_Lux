package modelo;

import java.sql.Date;

public class Sale {
    private int saleId;
    private int customerId;
    private int employeeId;
    private java.sql.Date saleDate;
    private Double saleTotal;

    public Sale(int saleId, int customerId, int employeeId, Date saleDate, double saleTotal){
        this.saleId = saleId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.saleDate = saleDate;
        this.saleTotal = saleTotal;
    }
    
      public Sale( int customerId, int employeeId, Date saleDate, double saleTotal){
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.saleDate = saleDate;
        this.saleTotal = saleTotal;
    }
    // Getters y Setters

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public java.sql.Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(java.sql.Date saleDate) {
        this.saleDate = saleDate;
    }

    public double getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(double saleTotal) {
        this.saleTotal = saleTotal;
    }
}

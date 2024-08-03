package modelo;

public class Cars {
    private String num_serie; 
    private int id_model;
    private int year;
    private double price;
    private String color;

    // Constructor por defecto
    public Cars() {
        this.num_serie = "";
        this.id_model = 0;
        this.year = 0;
        this.price = 0.0;
        this.color = "";
    }

    // Constructor con parámetros
    public Cars(String num_serie, int id_model, int year, double price, String color) {
        this.num_serie = num_serie;
        this.id_model = id_model;
        this.year = year;
        this.price = price;
        this.color = color;
    }
    
        public Cars(int id_model, int year, double price, String color) {
        this.id_model = id_model;
        this.year = year;
        this.price = price;
        this.color = color;
    }

    public String getNum_serie() {
        return num_serie;
    }

    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }

    public int getId_model() {
        return id_model;
    }

    public void setId_model(int id_model) {
        this.id_model = id_model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
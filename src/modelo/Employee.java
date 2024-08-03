package modelo;

public class Employee {

    //atributtes
    private int idEmployee;
    private String name;
    private String firstLastName;
    private String secondLastName;
    private String address;
    private String email;
    private String rol;

    //contructor por defecto
    public Employee() {
        this.idEmployee = 0;
        this.name = "";
        this.firstLastName = "";
        this.secondLastName = "";
        this.address = "";
        this.email = "";
        this.rol = "";
    }
    
    //constructor con parámetros
    public Employee(String name, String firstLastName, String secondLastName, String address, String email, String rol){
        this.idEmployee = 0;
        this.name = name;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.address = address;
        this.email = email;
        this.rol = rol;
    }
    
        public Employee(int idEmployee, String name, String firstLastName, String secondLastName, String address, String email, String rol){
        this.idEmployee = idEmployee;
        this.name = name;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.address = address;
        this.email = email;
        this.rol = rol;
    }


    public int getIdEmployee(){
        return idEmployee;
    }
    
    public void setIdEmployee(int id){
        idEmployee = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    @Override
    public String toString(){
        return this.name;
    }

}

package modelo;

public class Cliente {
    private String nombre;
    private String direccion;
    private String telefono;
    private String pagoElectronico;

    public Cliente(String nombre, String direccion, String telefono, String pagoElectronico) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.pagoElectronico = pagoElectronico;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPagoElectronico() {
        return pagoElectronico;
    }
    public void setPagoElectronico(String pagoElectronico) {
        this.pagoElectronico = pagoElectronico;
    }
}

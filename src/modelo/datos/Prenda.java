package modelo.datos;

public class Prenda{

    private Tipo prenda;
    private EstadoMexico estado;
    private Categoria categoria;
    private double costoProduccion, costoRenta, costoVenta;

    public Prenda(Tipo prenda, Categoria categoria, EstadoMexico estado, double costoProduccion, double costoRenta, double costoVenta){
        this.prenda = prenda;
        this.categoria = categoria;
        this.costoProduccion = costoProduccion;
        this.costoRenta = costoRenta;
        this.costoVenta = costoVenta;
        this.estado = estado;
    }

    public double getCostoRenta(){
        return costoRenta;
    }

    public double getCostoVenta(){
        return costoVenta;
    }

    @Override
    public String toString() {
        return "Prenda: " + prenda + "; Categoria: " +categoria+"; estado: "+ estado  +"; Costo Produccion: " + costoProduccion+ "; Costo Renta: " + costoRenta+ "; Costo Venta: "+ costoVenta;
    }
};

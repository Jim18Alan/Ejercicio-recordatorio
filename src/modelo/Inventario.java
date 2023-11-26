package modelo;

import java.util.ArrayList;
import modelo.datos.Prenda;

public class Inventario {

    ArrayList<Prenda> prendas;

    public Inventario(){
        prendas = new ArrayList<Prenda>();
    }

    public void addPrenda(Prenda p){
        prendas.add(p);
    }

    public void mostrarInventario(){
        System.out.println("Inventario disponible : ");
        for (int i = 0;  i < prendas.size(); i++){
            System.out.println("Codigo: "+ i + ";  " +prendas.get(i).toString());
        }
    }

    public int size() {
        return prendas.size();
    }

    public Prenda getPrenda(int id){
        return prendas.get(id);
    }
}

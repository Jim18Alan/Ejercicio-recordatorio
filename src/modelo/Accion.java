package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Accion {

    public static final int  RENTAR = 1, VENDER = 2;
    public static final int  REGISTRAR = 1, INICIARSESION = 2;
    public static final int  CANCELAR = 0;

    Inventario inventario;
    ArrayList<Cliente> clientes;
    ArrayList<Integer> carrito;

    public Accion(Inventario inventario, ArrayList<Cliente> clientes) {
        this.inventario = inventario;
        this.clientes = clientes;
        carrito = new ArrayList<>();
    }

    public void registrarCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        String nombre = sc.next();
        System.out.print("Direccion: ");
        String direccion = sc.next();
        System.out.print("Telefono: ");
        String tel = sc.next();
        System.out.print("Pago electronico: ");
        String pago = sc.next();
        clientes.add(new Cliente(nombre, direccion,tel, pago));
        System.out.println(" -- Cliente Registrado --\n");
    }

    public Cliente buscarCliente(String nombre){
        for (Cliente cliente: clientes) {
            if(cliente.getNombre().equals(nombre)){
                return cliente;
            }
        }
        return null;
    }

    public boolean agregarAlCarrito(int id){
        if(id < inventario.size() && id >= 0){
            carrito.add(id);
            return true;
        }
        return false;
    }

    public void vaciarCarrito(){
        carrito.clear();
    }

    public void rentar(){
        double costo = 0.0;
        System.out.println(" -- Prendas a Rentar: ");
        for (int i = 0;  i < carrito.size(); i++){
            System.out.println(inventario.getPrenda(carrito.get(i)).toString());
            costo += inventario.getPrenda(carrito.get(i)).getCostoRenta();
        }
        System.out.println(" -- Costo Total de Renta: " + costo);
    }

    public void vender(){
        double costo = 0.0;
        System.out.println(" -- Prendas a Comprar: ");
        for (int i = 0;  i < carrito.size(); i++){
            System.out.println(inventario.getPrenda(carrito.get(i)).toString());
            costo += inventario.getPrenda(carrito.get(i)).getCostoVenta();
        }
        System.out.println(" -- Costo Total de Venta: " + costo);
    }

    public boolean registro(int op, int opAccion){
        Scanner sc = new Scanner(System.in);
        int opcion;
        switch (op){
            case 0:
                if(opAccion == Accion.RENTAR){
                    System.out.println("Opcion no valida");
                    return false;
                }
                break;
            case 1:
                this.registrarCliente();
                break;
            case 2:
                boolean error;
                do {
                    error = true;
                    System.out.print("Nombre: ");
                    if(this.buscarCliente(sc.next()) != null){
                        System.out.println(" -- Datos del cliente encontrado --\n");
                        return true;
                    }else{
                        System.out.println(" -- Datos del cliente no encontrado --\n");
                        if(opAccion == Accion.VENDER){
                            System.out.print("0)cancelar (registro/sesion) , vuelve a 2)iniciar sesion o 1)registrate \nEleccion: ");
                            opcion = sc.nextInt();
                            switch (opcion){
                                case Accion.CANCELAR:
                                    return true;
                                case Accion.INICIARSESION:
                                    error = true;
                                    break;
                                case Accion.REGISTRAR:
                                    this.registrarCliente();
                                    error = false;
                                    break;
                                default:
                                    System.out.println("Opcion no valida");
                                    return false;
                            }
                        }else{
                            System.out.print("Vuelve a 2)iniciar sesion o 1)registrate  \nEleccion: ");
                            opcion = sc.nextInt();
                            switch (opcion){
                                case Accion.INICIARSESION:
                                    error = true;
                                    break;
                                case Accion.REGISTRAR:
                                    this.registrarCliente();
                                    error = false;
                                    break;
                                default:
                                    System.out.println("Opcion no valida");
                                    return false;
                            }
                        }
                    }
                }while(error);
                break;
            default:
                System.out.println("Opcion no valida");
                return false;
        }
        return true;
    }

}

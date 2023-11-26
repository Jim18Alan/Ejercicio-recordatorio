import modelo.Accion;
import modelo.Cliente;
import modelo.Inventario;
import modelo.datos.Categoria;
import modelo.datos.EstadoMexico;
import modelo.datos.Prenda;
import modelo.datos.Tipo;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.Scanner;

/*
Una viejita se dedica a la costura de prendas típicas folklóricas mexicanas. Tiene un inventario de
vestuarios típicos de todo el país (México, pero puede expandirse a otros países también).
Cada prenda (sombrero, blusa, pantalón, falda o zapato) tiene uno o varios estados mexicanos, una
categoría (de gala o común), un costo de producción, un costo de renta y un costo de venta.
Hay 32 estados de la república con nombre y región.
La viejita desea rentar o vender alguno de los vestuarios (Acción). Al rentar muestra una lista de las prendas a rentar con el costo total de renta de todas ellas.
Al vender muestra una lista de prendas a vender con el costo total de venta de todas ellas.

Las rentas se deben hacer a clientes registrados:
• Nombre
• Dirección
• Teléfono
• Pago electrónico
Las ventas se deben a hacer a clientes registrados y no registrados.
*/

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Accion accion = new Accion(inventario,clientes);

        //Rellenar el inventario
        rellenarInventario(inventario);
        //guardar algunos clientes
        agregarClientesExitentes(clientes);
        //-- iniciar compra/renta
        iniciar(inventario, accion, clientes);
    }

    public static void rellenarInventario(Inventario inventario){
        inventario.addPrenda(new Prenda(Tipo.PANTALON,Categoria.GALA, EstadoMexico.CAMPECHE,            100, 110, 120));
        inventario.addPrenda(new Prenda(Tipo.BLUSA,   Categoria.COMUN, EstadoMexico.BAJA_CALIFORNIA_SUR, 200, 210, 220));
        inventario.addPrenda(new Prenda(Tipo.FALDA,   Categoria.GALA, EstadoMexico.CAMPECHE,            300, 310, 320));
        inventario.addPrenda(new Prenda(Tipo.SOMBRERO, Categoria.COMUN, EstadoMexico.BAJA_CALIFORNIA_SUR, 400, 410, 420));
        inventario.addPrenda(new Prenda(Tipo.ZAPATO,  Categoria.GALA, EstadoMexico.CAMPECHE,            500, 510, 520));
    }

    public static void agregarClientesExitentes(ArrayList<Cliente> clientes){
        clientes.add(new Cliente("Jose", "Av.Hidalgo", "9712092094", "2312312312"));
        clientes.add(new Cliente("Jimmy", "Av. Romero", "9715092345", "2342342342"));
    }

    public static void iniciar(Inventario inventario, Accion accion, ArrayList<Cliente> clientes){
        Scanner sc = new Scanner(System.in);
        String seguir;
        int opcion;
        System.out.println("-------------Biemvenido-------------");
        do {
            accion.vaciarCarrito();
            inventario.mostrarInventario();
            System.out.println("\nElija sus prendas y agreguelas al carrito");
            do {
                System.out.print("Codigo: ");
                if(accion.agregarAlCarrito(sc.nextInt())){
                    System.out.println("-- Agregada al carrito");
                }else {
                    System.out.println("-- Error: codigo no valido");
                }
                System.out.print("\nAgregar otro (si/no):");
                seguir = sc.next();
            }while(seguir.equals("si"));

            do{
                seguir = "no";
                System.out.print("\nOpciones 1)Rentar  2)Comprar  \nEleccion: ");
                opcion = sc.nextInt();
                switch (opcion){
                    case Accion.RENTAR:
                        System.out.println("\nNecesita estar registrado para rentar");
                        System.out.print("1) Registrarse 2) Iniciar sesion con nombre \nEleccion:");
                        while (!accion.registro(sc.nextInt(), Accion.RENTAR)){
                            System.out.print("\nEleccion: ");
                        };
                        accion.rentar();
                        break;
                    case Accion.VENDER:
                        System.out.print("Desea registrarse/ingresar (si/no): ");
                        if(sc.next().equals("si")){
                            System.out.print("0) Cancelar (registro/sesion) 1) Registrarse 2) Iniciar sesion con nombre  \nEleccion: ");
                            //accion.registro(sc.nextInt(), Accion.VENDER);
                            while (!accion.registro(sc.nextInt(), Accion.VENDER)){
                                System.out.print("\nEleccion: ");
                            };
                        }
                        accion.vender();
                        break;
                    default:
                        System.out.println("Opcion no valida ");
                        seguir = "si";
                        break;
                }
            }while(seguir.equals("si"));
            System.out.print("\nQuiere hacer otra compra/renta (si/no): ");
            seguir = sc.next();
        }while(seguir.equals("si"));
    }
}

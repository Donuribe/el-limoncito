import dominio.*;
import dominio.Catalogo.Producto;
import servicios.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LimoncitoServicio servicio = new LimoncitoServicio();

        // Solicitar datos del cliente
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese el teléfono del cliente: ");
        String telefono = scanner.nextLine();
        
        System.out.print("¿Desea servicio express? (s/n): ");
        String respuestaExpres = scanner.nextLine().trim().toLowerCase();
        boolean esExpres = respuestaExpres.equals("s") || respuestaExpres.equals("si") || respuestaExpres.equals("sí");
        
        // Crear pedido
        Pedido pedido = servicio.crearPedido(nombre, telefono, esExpres);

        // Agregar ítems del catálogo fijo
        System.out.println("\n=== CATÁLOGO DE PRODUCTOS ===");
        
        // Camisa
        System.out.print("Cantidad de Camisas ($4.000 / $3.500 desde 5 unidades): ");
        int cantidadCamisas = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        if (cantidadCamisas > 0) {
            try {
                servicio.agregarItem(pedido, Producto.CAMISA, cantidadCamisas);
            } catch (IllegalArgumentException e) {
                System.out.println("✗ Error: " + e.getMessage());
            }
        }
        
        // Pantalón
        System.out.print("Cantidad de Pantalones ($6.000 / $5.000 desde 5 unidades): ");
        int cantidadPantalones = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        if (cantidadPantalones > 0) {
            try {
                servicio.agregarItem(pedido, Producto.PANTALON, cantidadPantalones);
            } catch (IllegalArgumentException e) {
                System.out.println("✗ Error: " + e.getMessage());
            }
        }
        
        // Chaqueta
        System.out.print("Cantidad de Chaquetas ($9.000 / $7.500 desde 5 unidades): ");
        int cantidadChaquetas = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        if (cantidadChaquetas > 0) {
            try {
                servicio.agregarItem(pedido, Producto.CHAQUETA, cantidadChaquetas);
            } catch (IllegalArgumentException e) {
                System.out.println("✗ Error: " + e.getMessage());
            }
        }

        // Mostrar resumen preliminar
        servicio.mostrarResumenPreliminar(pedido);
        
        // Preguntar si desea confirmar el pedido
        System.out.print("\n¿Desea confirmar el pedido? (s/n): ");
        String respuestaConfirmar = scanner.nextLine().trim().toLowerCase();
        boolean confirmar = respuestaConfirmar.equals("s") || respuestaConfirmar.equals("si") || respuestaConfirmar.equals("sí");
        
        if (confirmar) {
            // Confirmar pedido
            servicio.confirmarPedido(pedido);
            System.out.println("\n✓ Pedido confirmado exitosamente");
        } else {
            System.out.println("\n✗ Pedido cancelado");
        }
        
        scanner.close();
    }
}


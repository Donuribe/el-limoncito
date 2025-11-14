package servicios;

import dominio.*;
import dominio.Catalogo.Producto;

public class LimoncitoServicio {

    public Pedido crearPedido(String nombre, String telefono, boolean esExpres) {
        Cliente cliente = new Cliente(nombre, telefono);
        return new Pedido(cliente, esExpres);
    }

    public void agregarItem(Pedido pedido, Producto producto, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        double precio = Catalogo.obtenerPrecio(producto, cantidad);
        ItemPedido item = new ItemPedido(producto, cantidad, precio);
        pedido.agregarItem(item);
    }

    public void mostrarResumenPreliminar(Pedido pedido) {
        System.out.println("\n===== RESUMEN PRELIMINAR =====");
        pedido.mostrarResumen();
    }

    public void confirmarPedido(Pedido pedido) {
        System.out.println("\n===== RESUMEN DEL PEDIDO =====");
        pedido.mostrarResumen();
    }
}

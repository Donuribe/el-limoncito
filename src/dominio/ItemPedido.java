package dominio;

import dominio.Catalogo.Producto;

public class ItemPedido {
    private Producto producto;
    private int cantidad;
    private double precioUnitario;

    public ItemPedido(Producto producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }

    @Override
    public String toString() {
        return producto.name() + " x" + cantidad + " = $" + calcularSubtotal();
    }
}
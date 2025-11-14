package dominio;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<ItemPedido> items;
    private boolean esExpres;

    public Pedido(Cliente cliente, boolean esExpres) {
        this.cliente = cliente;
        this.esExpres = esExpres;
        this.items = new ArrayList<>();
    }

    public void agregarItem(ItemPedido item) {
        items.add(item);
    }

    public double calcularTotalBruto() {
        double total = 0;
        for (ItemPedido item : items) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public double calcularRecargo() {
        return esExpres ? calcularTotalBruto() * 0.10 : 0;
    }

    public double calcularDescuento() {
        double totalConRecargo = calcularTotalBruto() + calcularRecargo();
        return totalConRecargo > 60000 ? totalConRecargo * 0.05 : 0;
    }

    public double calcularTotalFinal() {
        return calcularTotalBruto() + calcularRecargo() - calcularDescuento();
    }

    public void mostrarResumen() {
        System.out.println("Cliente: " + cliente);
        System.out.println("Detalle del pedido:");
        for (ItemPedido item : items) {
            System.out.println("  - " + item);
        }
        System.out.println("Total bruto: $" + calcularTotalBruto());
        if (esExpres) System.out.println("Recargo (servicio exprés): $" + calcularRecargo());
        System.out.println("Descuento: $" + calcularDescuento());
        System.out.println("TOTAL FINAL: $" + calcularTotalFinal());
    }
}
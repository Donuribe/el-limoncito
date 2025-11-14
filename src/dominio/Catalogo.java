package dominio;

public class Catalogo {

    public enum Producto {
        CAMISA(4000, 3500),
        PANTALON(6000, 5000),
        CHAQUETA(9000, 7500);

        private final double precioRegular;
        private final double precioUnidad;

        Producto(double precioRegular, double precioUnidad) {
            this.precioRegular = precioRegular;
            this.precioUnidad = precioUnidad;
        }

        public double obtenerPrecio(int cantidad) {
            return cantidad >= 5 ? precioUnidad : precioRegular;
        }

        public double getPrecioRegular() {
            return precioRegular;
        }

        public double getPrecioVolumen() {
            return precioUnidad;
        }
    }

    public static double obtenerPrecio(Producto producto, int cantidad) {
        if (producto == null || cantidad <= 0) {
            return 0;
        }
        return producto.obtenerPrecio(cantidad);
    }
}
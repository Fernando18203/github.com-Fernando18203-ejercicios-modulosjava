public class Factura {

    // Atributos
    private String nombreProducto;
    private int cantidad;
    private double precioUnitario;

    // Constructor
    public Factura(String nombreProducto, int cantidad, double precioUnitario) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    // Getters y Setters
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    // Métodos
    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }

    public double calcularTotalConIVA() {
        double subtotal = calcularSubtotal();
        return subtotal * 1.16;
    }
}

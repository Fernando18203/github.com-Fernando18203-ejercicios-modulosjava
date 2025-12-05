public class ProductoAlmacen {

    private String referencia;
    private int cantidadActual;
    private double precioUnitario;

    // Constructor
    public ProductoAlmacen(String referencia, int cantidadActual, double precioUnitario) {
        this.referencia = referencia;
        this.cantidadActual = cantidadActual;
        this.precioUnitario = precioUnitario;
    }

    // Getters y Setters
    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    // 1. Incrementar stock
    public void incrementarStock(int cantidadEntrada) {
        if (cantidadEntrada > 0) {
            cantidadActual += cantidadEntrada;
        }
    }

    // 2. Calcular valor total del stock
    public double calcularValorTotal() {
        return cantidadActual * precioUnitario;
    }
}

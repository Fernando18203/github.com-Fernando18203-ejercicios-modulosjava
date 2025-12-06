public class Automovil {

    private String marca;
    private int anoFabricacion;
    private double velocidadMaxima;

    public Automovil(String marca, int anoFabricacion, double velocidadMaxima) {
        this.marca = marca;
        this.anoFabricacion = anoFabricacion;
        this.velocidadMaxima = velocidadMaxima;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(int anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    // Método corregido
    public boolean encender(int anoActual) {
        int antiguedad = anoActual - anoFabricacion;
        return antiguedad <= 20; // Aquí ajusta el valor si deseas otro criterio
    }

    public int calcularAntiguedad(int anoActual) {
        return anoActual - anoFabricacion;
    }
}

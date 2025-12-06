public class Estudiante {

    private String nombre;
    private double calificacion1;
    private double calificacion2;

    // Constructor
    public Estudiante(String nombre, double calificacion1, double calificacion2) {
        this.nombre = nombre;
        this.calificacion1 = calificacion1;
        this.calificacion2 = calificacion2;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCalificacion1() {
        return calificacion1;
    }

    public void setCalificacion1(double calificacion1) {
        this.calificacion1 = calificacion1;
    }

    public double getCalificacion2() {
        return calificacion2;
    }

    public void setCalificacion2(double calificacion2) {
        this.calificacion2 = calificacion2;
    }

    // Calcular promedio
    public double calcularPromedio() {
        return (calificacion1 + calificacion2) / 2;
    }

    // Verificar si aprobó
    public boolean aprobo() {
        return calcularPromedio() >= 70;
    }
}

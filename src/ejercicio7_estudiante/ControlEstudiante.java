import java.util.Scanner;

public class ControlEstudiante {

    Scanner sc = new Scanner(System.in);

    public void ejecutar() {

        System.out.println("=== SISTEMA DE CALIFICACIÓN DE ESTUDIANTES ===");

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese la primera calificación: ");
        double c1 = sc.nextDouble();

        System.out.print("Ingrese la segunda calificación: ");
        double c2 = sc.nextDouble();

        Estudiante est = new Estudiante(nombre, c1, c2);

        System.out.println("\n=== DATOS DEL ESTUDIANTE ===");
        System.out.println("Nombre: " + est.getNombre());
        System.out.println("Calificación 1: " + est.getCalificacion1());
        System.out.println("Calificación 2: " + est.getCalificacion2());

        System.out.println("\n=== COMPORTAMIENTO 1: Calcular Promedio ===");
        double promedio = est.calcularPromedio();
        System.out.println("Promedio final: " + promedio);

        System.out.println("\n=== COMPORTAMIENTO 2: Resultado Final ===");
        if (est.aprobo()) {
            System.out.println("El estudiante APROBÓ.");
        } else {
            System.out.println("El estudiante NO APROBÓ.");
        }

        System.out.println("\n=== FIN DEL EJERCICIO 7 ===\n");
    }
}

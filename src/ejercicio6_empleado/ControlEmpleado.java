import java.util.Scanner;

public class ControlEmpleado {

    Scanner sc = new Scanner(System.in);

    public void ejecutar() {

        System.out.println("=== CONTROL DE EMPLEADOS ===");

        System.out.print("Nombre del empleado: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese el salario base mensual: ");
        double salario = sc.nextDouble();

        System.out.print("Ingrese los días asistidos: ");
        int asistidos = sc.nextInt();

        System.out.print("Ingrese el total de días laborables del mes: ");
        int diasTotales = sc.nextInt();

        Empleado emp = new Empleado(nombre, salario, asistidos);

        System.out.println("\n=== ATRIBUTOS DEL EMPLEADO ===");
        System.out.println("Nombre: " + emp.getNombre());
        System.out.println("Salario base: $" + emp.getSalarioBase());
        System.out.println("Días asistidos: " + emp.getDiasAsistidos());

        System.out.println("\n=== COMPORTAMIENTO 1: Cálculo de Salario ===");
        double salarioTotal = emp.calcularSalarioTotal(diasTotales);
        System.out.println("Salario correspondiente al mes: $" + salarioTotal);

        System.out.println("\n=== COMPORTAMIENTO 2: Verificación de Asistencia ===");
        if (emp.asistenciaCompleta(diasTotales)) {
            System.out.println("El empleado cumplió con todos los días laborables.");
        } else {
            System.out.println("El empleado NO cumplió con todos los días laborables.");
        }

        System.out.println("\n=== FIN DEL EJERCICIO 6 ===\n");
    }
}

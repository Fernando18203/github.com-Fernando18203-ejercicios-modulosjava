import java.time.LocalDate;
import java.util.Scanner;

public class ControlAutomovil {

    Scanner sc = new Scanner(System.in);

    public void ejecutar() {

        System.out.println("=== DATOS DE VEHÍCULO: AUTOMÓVIL ===");

        System.out.print("Ingrese la marca del vehículo: ");
        String marca = sc.nextLine();

        System.out.print("Ingrese el año de fabricación: ");
        int ano = sc.nextInt();

        System.out.print("Ingrese la velocidad máxima (km/h): ");
        double velMax = sc.nextDouble();

        Automovil auto = new Automovil(marca, ano, velMax);

        int anoActual = LocalDate.now().getYear();

        System.out.println("\n=== ATRIBUTOS DEL AUTOMÓVIL ===");
        System.out.println("Marca: " + auto.getMarca());
        System.out.println("Año de fabricación: " + auto.getAnoFabricacion());
        System.out.println("Velocidad máxima: " + auto.getVelocidadMaxima() + " km/h");

        System.out.println("\n=== COMPORTAMIENTO 1: Encender Vehículo ===");
        boolean seEncendio = auto.encender(anoActual);

        if (seEncendio) {
            System.out.println("El vehículo encendió correctamente.");
        } else {
            System.out.println("El vehículo NO encendió (demasiado antiguo).");
        }

        int antiguedad = auto.calcularAntiguedad(anoActual);

        System.out.println("\n=== COMPORTAMIENTO 2: Antigüedad del Vehículo ===");
        System.out.println("El automóvil tiene " + antiguedad + " años de antigüedad.");

        System.out.println("\n=== FIN DEL EJERCICIO 5 ===\n");
    }
}

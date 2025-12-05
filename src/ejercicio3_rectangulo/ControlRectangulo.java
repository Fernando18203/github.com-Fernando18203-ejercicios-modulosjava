import java.util.Scanner;

public class ControlRectangulo {

    Scanner sc = new Scanner(System.in);

    public void ejecutar() {

        System.out.println("=== GEOMETRÍA: RECTÁNGULO ===");

        System.out.print("Ingrese la base del rectángulo: ");
        double base = sc.nextDouble();

        System.out.print("Ingrese la altura del rectángulo: ");
        double altura = sc.nextDouble();

        sc.nextLine(); // Limpia el buffer
        System.out.print("Ingrese una etiqueta de identificación: ");
        String etiqueta = sc.nextLine();

        // Crear objeto Rectangulo
        Rectangulo rect = new Rectangulo(base, altura, etiqueta);

        System.out.println("\n=== ATRIBUTOS DEL RECTÁNGULO ===");
        System.out.println("Base: " + rect.getBase());
        System.out.println("Altura: " + rect.getAltura());
        System.out.println("Etiqueta: " + rect.getEtiqueta());

        System.out.println("\n=== COMPORTAMIENTO 1: Calcular Área ===");
        double area = rect.calcularArea();
        System.out.println("El área del rectángulo es: " + area);

        System.out.println("\n=== COMPORTAMIENTO 2: Calcular Perímetro ===");
        double perimetro = rect.calcularPerimetro();
        System.out.println("El perímetro del rectángulo es: " + perimetro);

        System.out.println("\n=== FIN DEL EJERCICIO 3 ===\n");
    }
}

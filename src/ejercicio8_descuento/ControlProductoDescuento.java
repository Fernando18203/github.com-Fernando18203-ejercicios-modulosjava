import java.util.Scanner;

public class ControlProductoDescuento {

    Scanner sc = new Scanner(System.in);

    public void ejecutar() {

        System.out.println("=== SISTEMA DE DESCUENTO DE PRODUCTOS ===");

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese el precio original: ");
        double precio = sc.nextDouble();

        System.out.print("Ingrese el porcentaje de descuento (%): ");
        double descuento = sc.nextDouble();

        Producto prod = new Producto(nombre, precio, descuento);

        System.out.println("\n=== DATOS DEL PRODUCTO ===");
        System.out.println("Producto: " + prod.getNombre());
        System.out.println("Precio original: $" + prod.getPrecioOriginal());
        System.out.println("Descuento: " + prod.getPorcentajeDescuento() + "%");

        System.out.println("\n=== COMPORTAMIENTO 1: Calcular Monto del Descuento ===");
        double montoDescuento = prod.calcularMontoDescuento();
        System.out.println("Monto descontado: $" + montoDescuento);

        System.out.println("\n=== COMPORTAMIENTO 2: Precio Final ===");
        double precioFinal = prod.calcularPrecioFinal();
        System.out.println("Precio final después del descuento: $" + precioFinal);

        System.out.println("\n=== FIN DEL EJERCICIO 8 ===\n");
    }
}

import java.util.Scanner;

public class ControlFactura {

    Scanner sc = new Scanner(System.in);

    public void ejecutar() {

        System.out.println("=== SISTEMA DE FACTURACIÓN SIMPLE ===");

        System.out.print("Ingrese el nombre del producto: ");
        String nombreProducto = sc.nextLine();

        System.out.print("Ingrese la cantidad comprada: ");
        int cantidad = sc.nextInt();

        System.out.print("Ingrese el precio unitario: ");
        double precio = sc.nextDouble();

        Factura factura = new Factura(nombreProducto, cantidad, precio);

        System.out.println("\n=== DATOS DE LA FACTURA ===");
        System.out.println("Producto: " + factura.getNombreProducto());
        System.out.println("Cantidad: " + factura.getCantidad());
        System.out.println("Precio unitario: $" + factura.getPrecioUnitario());

        System.out.println("\n=== COMPORTAMIENTO 1: Subtotal ===");
        double subtotal = factura.calcularSubtotal();
        System.out.println("Subtotal: $" + subtotal);

        System.out.println("\n=== COMPORTAMIENTO 2: Total con IVA (16%) ===");
        double total = factura.calcularTotalConIVA();
        System.out.println("Total a pagar: $" + total);

        System.out.println("\n=== FIN DEL EJERCICIO 10 ===\n");
    }
}

import java.util.Scanner;

public class ControlProducto {

    Scanner sc = new Scanner(System.in);

    public void ejecutar() {

        System.out.println("=== CONTROL DE INVENTARIO ===");

        System.out.print("Ingrese la referencia del producto: ");
        String ref = sc.nextLine();

        System.out.print("Ingrese la cantidad inicial en stock: ");
        int cant = sc.nextInt();

        System.out.print("Ingrese el precio unitario: ");
        double precio = sc.nextDouble();

        ProductoAlmacen producto = new ProductoAlmacen(ref, cant, precio);

        System.out.println("\n=== ATRIBUTOS DEL PRODUCTO ===");
        System.out.println("Referencia: " + producto.getReferencia());
        System.out.println("Cantidad actual: " + producto.getCantidadActual());
        System.out.println("Precio unitario: $" + producto.getPrecioUnitario());

        System.out.println("\n=== COMPORTAMIENTO 1: Incrementar Stock ===");
        System.out.print("Ingrese la cantidad de mercancía que va a entrar: ");
        int entrada = sc.nextInt();

        producto.incrementarStock(entrada);
        System.out.println("Stock actualizado: " + producto.getCantidadActual());

        System.out.println("\n=== COMPORTAMIENTO 2: Valor Total del Stock ===");
        double valorTotal = producto.calcularValorTotal();
        System.out.println("Valor total del stock: $" + valorTotal);

        System.out.println("\n=== FIN DEL EJERCICIO 2 ===\n");
    }
}

import java.util.Scanner;

public class ControlCuentaAhorro {

    Scanner sc = new Scanner(System.in);

    public void ejecutar() {

        System.out.println("=== SISTEMA DE CUENTA DE AHORRO ===");

        System.out.print("Ingrese el número de cuenta: ");
        String cuenta = sc.nextLine();

        System.out.print("Ingrese el nombre del titular: ");
        String titular = sc.nextLine();

        System.out.print("Ingrese el saldo inicial: ");
        double saldo = sc.nextDouble();

        CuentaAhorro c = new CuentaAhorro(cuenta, titular, saldo);

        System.out.println("\n=== DATOS DE LA CUENTA ===");
        System.out.println("Número de cuenta: " + c.getNumeroCuenta());
        System.out.println("Titular: " + c.getTitular());
        System.out.println("Saldo actual: $" + c.getSaldo());

        System.out.println("\n=== COMPORTAMIENTO 1: Depósito ===");
        System.out.print("Ingrese la cantidad a depositar: ");
        double deposito = sc.nextDouble();
        c.depositar(deposito);
        System.out.println("Saldo después del depósito: $" + c.getSaldo());

        System.out.println("\n=== COMPORTAMIENTO 2: Retiro ===");
        System.out.print("Ingrese la cantidad a retirar: ");
        double retiro = sc.nextDouble();

        if (c.retirar(retiro)) {
            System.out.println("Retiro exitoso.");
        } else {
            System.out.println("Fondos insuficientes.");
        }

        System.out.println("Saldo final: $" + c.getSaldo());
        System.out.println("\n=== FIN DEL EJERCICIO 4 ===\n");
    }
}

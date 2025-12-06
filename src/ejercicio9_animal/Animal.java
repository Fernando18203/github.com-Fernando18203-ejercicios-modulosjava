import java.util.Scanner;

public class ControlAnimal {

    Scanner sc = new Scanner(System.in);

    public void ejecutar() {

        System.out.println("=== CONTROL DE ANIMALES ===");

        System.out.print("Ingrese el nombre del animal: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese la especie: ");
        String especie = sc.nextLine();

        System.out.print("Ingrese la energía inicial (0 a 100): ");
        int energia = sc.nextInt();

        Animal animal = new Animal(nombre, especie, energia);

        System.out.println("\n=== DATOS DEL ANIMAL ===");
        System.out.println("Nombre: " + animal.getNombre());
        System.out.println("Especie: " + animal.getEspecie());
        System.out.println("Energía inicial: " + animal.getEnergia());

        System.out.println("\n=== COMPORTAMIENTO 1: Consumir Energía ===");
        System.out.print("Ingrese cuánta energía se va a consumir: ");
        int consumo = sc.nextInt();
        System.out.println(animal.consumirEnergia(consumo));

        System.out.println("\n=== COMPORTAMIENTO 2: Descansar ===");
        System.out.print("Ingrese cuánta energía va a recuperar: ");
        int descanso = sc.nextInt();
        System.out.println(animal.descansar(descanso));

        System.out.println("\n=== FIN DEL EJERCICIO 9 ===\n");
    }
}

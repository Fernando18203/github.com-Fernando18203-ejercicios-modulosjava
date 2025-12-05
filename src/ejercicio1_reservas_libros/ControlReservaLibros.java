import java.time.LocalDate; import java.util.ArrayList; import java.util.List; import java.util.Scanner;
public class ControlReservaLibros {
    private List<ArticuloBibliografico> libros;     private Scanner sc;     private int anoActual;
    public ControlReservaLibros() {         sc = new Scanner(System.in);         libros = new ArrayList<>();         anoActual = LocalDate.now().getYear(); // toma el año en curso del sistema
        // 5 reservables (publicados antes de anoActual-5)         libros.add(new ArticuloBibliografico(101, "Cien años de soledad", "Gabriel García Márquez", Math.max(200         libros.add(new ArticuloBibliografico(102, "Don Quijote de la Mancha", "Miguel de Cervantes", Math.max(20         libros.add(new ArticuloBibliografico(103, "El Hobbit", "J. R. R. Tolkien", Math.max(2007, anoActual - 12         libros.add(new ArticuloBibliografico(104, "El Perfume", "Patrick Süskind", Math.max(2007, anoActual - 10         libros.add(new ArticuloBibliografico(105, "Orgullo y Prejuicio", "Jane Austen", Math.max(2007, anoActual
        // 5 no reservables (publicados en los últimos 5 años o exactamente 5 años)         libros.add(new ArticuloBibliografico(201, "El Principito (Ed. reciente)", "Antoine de Saint-Exupéry", Ma         libros.add(new ArticuloBibliografico(202, "Harry Potter y la Piedra Filosofal (Ed. nueva)", "J. K. Rowli         libros.add(new ArticuloBibliografico(203, "Los Juegos del Hambre (Ed. nueva)", "Suzanne Collins", Math.m         libros.add(new ArticuloBibliografico(204, "El Código Da Vinci (Ed. nueva)", "Dan Brown", Math.max(2007,         libros.add(new ArticuloBibliografico(205, "It (Ed. nueva)", "Stephen King", Math.max(2007, anoActual - 1     }
    // Mostrar tabla tipo A (sin disponible/reservable)     private void mostrarTabla(List<ArticuloBibliografico> lista) {         System.out.println("\nID    | Título                                 | Autor");         System.out.println("---------------------------------------------------------------------");         for (ArticuloBibliografico libro : lista) {             System.out.printf("%-5d | %-38s | %s\n",                     libro.getId(),                     libro.getTitulo(),                     libro.getAutor());         }
    }
    // Mostrar tabla pero excluyendo libros ya reservados
    private void mostrarTablaNoReservados(List<ArticuloBibliografico> lista) {         List<ArticuloBibliografico> filtro = new ArrayList<>();         for (ArticuloBibliografico l : lista) {             if (!l.isReservado()) filtro.add(l);         }
        if (filtro.isEmpty()) {             System.out.println("\nNo hay libros disponibles para mostrar.");         } else {             mostrarTabla(filtro);         }
    }
    // Buscar libro por ID (retorna null si no existe)     private ArticuloBibliografico buscarPorId(int id) {         for (ArticuloBibliografico l : libros) {             if (l.getId() == id) return l;         }         return null;     }
    // Ejecuta el flujo principal     public void ejecutar() {         boolean terminarPrograma = false;
        while (!terminarPrograma) {             System.out.println("\n=== SISTEMA DE RESERVA DE LIBROS ===");             // Mostrar todos los libros (tabla A) — NOTA: no muestra si están reservados o no             mostrarTabla(libros);
            System.out.print("\n¿Qué ID de libro desea reservar?: ");             int idSeleccion;             try {                 idSeleccion = Integer.parseInt(sc.nextLine().trim());             } catch (Exception e) {                 System.out.println("Entrada no válida. Se regresa al inicio.");                 continue;             }             ArticuloBibliografico elegido = buscarPorId(idSeleccion);
            if (elegido == null) {                 System.out.println("ID no válido.");                 continue;             }
            // Si ya fue reservado anteriormente en el sistema             if (elegido.isReservado()) {                 System.out.println("\nLo siento, este libro ya está reservado.");
                System.out.print("¿Desea reservar algún otro? (si/no): ");                 String resp = sc.nextLine().trim();                 if (resp.equalsIgnoreCase("si")) {                     // Mostrar tabla de libros no reservados y continuar                     mostrarTablaNoReservados(libros);                     continue;                 } else {
                    System.out.print("¿Entonces desea salir del programa? (si/no): ");                     String salida = sc.nextLine().trim();                     if (salida.equalsIgnoreCase("si")) {                         System.out.println("Saliendo del programa...");                         return;                     } else {                         continue;                     }
                }
            }
            // Verificar antigüedad             int antiguedad = elegido.calcularAntiguedad(anoActual);             if (!elegido.esReservable(anoActual)) {                 // No reservable por antigüedad
                System.out.println("\nLo siento, este libro no está disponible ya que se publicó hace " + antigu
                System.out.print("¿Desea reservar algún otro? (si/no): ");                 String resp = sc.nextLine().trim();                 if (resp.equalsIgnoreCase("si")) {                     // Mostrar tabla pero excluyendo ya reservados (aun así tabla no muestra estado)                     mostrarTablaNoReservados(libros);                     continue;                 } else {
                    System.out.print("¿Entonces desea salir del programa? (si/no): ");                     String salida = sc.nextLine().trim();                     if (salida.equalsIgnoreCase("si")) {                         System.out.println("Saliendo del programa...");                         return;                     } else {                         continue;                     }
                }
            }
            // Si llegamos aquí, el libro existe, no está reservado y es reservable (antigüedad > 5)
            // Aquí implementamos el flujo de "carrito": permitir al usuario agregar varios antes de finalizar             List<ArticuloBibliografico> carrito = new ArrayList<>();             carrito.add(elegido);             System.out.println("\nEl libro se puede reservar (tiene " + antiguedad + " años).");
            boolean enCarrito = true;             while (enCarrito) {                 System.out.print("¿Desea reservar algún otro libro antes de finalizar? (si/no): ");                 String respuesta = sc.nextLine().trim();
                if (respuesta.equalsIgnoreCase("si")) {
                    // Mostrar únicamente los libros que NO están reservados y que no estén ya en el carrito                     List<ArticuloBibliografico> opciones = new ArrayList<>();                     for (ArticuloBibliografico l : libros) {                         if (!l.isReservado() && !carrito.contains(l)) opciones.add(l);                     }
                    if (opciones.isEmpty()) {                         System.out.println("No hay más libros disponibles para agregar.");
                        // preguntar si desea finalizar directamente
                        System.out.print("¿Desea finalizar su reserva? (si/no): ");                         String finaliza = sc.nextLine().trim();                         if (finaliza.equalsIgnoreCase("si")) {                             // finalizar abajo                             enCarrito = false;                             break;                         } else {                             // volver al inicio                             enCarrito = false;                             break;                         }                     } else {
                        mostrarTabla(opciones);                         System.out.print("\n¿Cuál desea reservar ahora (ID)?: ");                         int idNuevo;                         try {                             idNuevo = Integer.parseInt(sc.nextLine().trim());                         } catch (Exception e) {                             System.out.println("Entrada no válida. Regresando al menú del carrito.");                             continue;                         }
                        ArticuloBibliografico elegidoNuevo = buscarPorId(idNuevo);                         if (elegidoNuevo == null) {                             System.out.println("ID no válido. Regresando al carrito.");                             continue;                         }
                        if (elegidoNuevo.isReservado()) {                             System.out.println("Lo siento, este libro ya está reservado.");                             continue;                         }                         int antig2 = elegidoNuevo.calcularAntiguedad(anoActual);                         if (!elegidoNuevo.esReservable(anoActual)) {                             System.out.println("Lo siento, este libro no está disponible ya que se publicó hace                             continue;                         }                         // agregar al carrito                         carrito.add(elegidoNuevo);                         System.out.println("Libro agregado al carrito: " + elegidoNuevo.getTitulo());
                        // se repite el while para preguntar si quiere otro
                    }
                } else {
                    // respuesta NO -> preguntar si desea finalizar la reserva
                    System.out.print("¿Desea finalizar su reserva? (si/no): ");                     String finalizar = sc.nextLine().trim();                     if (finalizar.equalsIgnoreCase("si")) {                         enCarrito = false; // sale del while y finaliza abajo                     } else {                         // volver al inicio del programa                         enCarrito = false;                     }
                }
            } // fin del while carrito
            // Si carrito tiene al menos 1 libro, procedemos a marcar reservas (finalizar)             if (!carrito.isEmpty()) {                 // Confirmación final antes de marcar                 System.out.println("\nSe finalizará la reserva de los siguientes libros:");                 for (ArticuloBibliografico l : carrito) {                     System.out.println("- (" + l.getId() + ") " + l.getTitulo() + " - " + l.getAutor());
                }
                // Marcar todos como reservados
                for (ArticuloBibliografico l : carrito) {
                    l.setReservado(true);                 }
                System.out.println("\nReserva exitosa.");
                System.out.print("¿Desea salir del programa? (si/no): ");                 String salir = sc.nextLine().trim();                 if (salir.equalsIgnoreCase("si")) {                     System.out.println("Saliendo del programa...");                     return;                 } else {                     // volver al inicio del sistema con los libros actualizados (algunos ya reservados)                     continue;                 }
            } else {                 // carrito vacío — vuelve al inicio                 continue;             }
        } // fin while principal
    }
}

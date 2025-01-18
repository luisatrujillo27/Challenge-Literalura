import java.util.Scanner;

public class BookCatalog {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Libros simulados con título y detalles
        String[][] books = {
                {"El Principito", "Autor: Antoine de Saint-Exupéry, Género: Ficción, Año: 1943"},
                {"1984", "Autor: George Orwell, Género: Distopía, Año: 1949"},
                {"Cien años de soledad", "Autor: Gabriel García Márquez, Género: Realismo Mágico, Año: 1967"}
        };

        // Menú principal
        while (true) {
            System.out.println("\nBienvenido al catálogo de libros");
            System.out.println("1. Buscar libros");
            System.out.println("2. Ver detalles de un libro");
            System.out.println("3. Ver autores");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            // Obtener la opción del usuario
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de leer el número

            switch (option) {
                case 1: // Buscar libros
                    System.out.println("\nLibros disponibles:");
                    for (String[] book : books) {
                        System.out.println("- " + book[0]);
                    }
                    break;

                case 2: // Ver detalles de un libro
                    System.out.print("\nIngrese el título del libro para ver detalles: ");
                    String title = scanner.nextLine();
                    boolean found = false;

                    for (String[] book : books) {
                        if (book[0].equalsIgnoreCase(title)) {
                            System.out.println("Detalles del libro:");
                            System.out.println(book[1]);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("El libro no se encuentra en el catálogo.");
                    }
                    break;

                case 3: // Ver autores
                    System.out.println("\nLista de autores:");
                    for (String[] book : books) {
                        System.out.println("- " + book[1].split(",")[0].replace("Autor: ", ""));
                    }
                    break;

                case 4: // Salir
                    System.out.println("\nGracias por usar el catálogo. ¡Adiós!");
                    scanner.close();
                    return; // Salir del programa

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}


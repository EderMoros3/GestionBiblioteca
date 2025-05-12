import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    private static final Scanner sc = new Scanner(System.in);
    private static final GestorLibros gestor = new GestorLibros();
    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n----Menu de Biblioteca----");
            System.out.println("1. Añadir libro");
            System.out.println("2. Buscar libro por ISBN");
            System.out.println("3. Buscar libro por autor");
            System.out.println("4. Buscar libro por titulo");
            System.out.println("5. Mostrar todos los libros");
            System.out.println("6. Salir");
            System.out.println("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> añadirLibro();
                case 2 -> buscarLibroISBN();
                case 3 -> buscarLibroAutor();
                case 4 -> buscarLibroTitulo();
                case 5 -> mostrarTodosLibros();
                case 6 -> System.out.println("Saliendo del programa...");
            }
        } while (opcion != 6);
    }
}

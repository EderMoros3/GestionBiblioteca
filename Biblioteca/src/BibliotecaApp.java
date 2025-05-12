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

    private static void añadirLibro() {
        ArrayList<Libro> libros = gestor.cargarLibros();

        System.out.println("Titulo: ");
        String titulo = sc.nextLine().trim();
        System.out.println("Autor: ");
        String autor = sc.nextLine().trim();
        System.out.println("ISBN: ");
        String isbn = sc.nextLine().trim();
        System.out.println("Año de publicacion: ");
        String yearStr = sc.nextLine().trim();

        if (titulo.isEmpty() || autor.isEmpty() || isbn.isEmpty() || yearStr.isEmpty()) {
            System.out.println("Error: Todos los campos son obligatorios");
            return;
        }

        if (gestor.existeISBN(libros, isbn)) {
            System.out.println("Error: ISBN duplicado");
            return;
        }

        try {
            int year = Integer.parseInt(yearStr);
            Libro nuevoLibro = new Libro(titulo, autor, isbn, year);
            gestor.guardarLibro(nuevoLibro);
            System.out.println("Libro añadido con exito");
        } catch (NumberFormatException e) {
            System.err.println("Error: Año debe de ser numerico");
        }
    }

    private static void buscarLibroISBN() {
        ArrayList<Libro> libros = gestor.cargarLibros();

        System.out.println("ISBN a buscar: ");
        String isbn = sc.nextLine().trim();

        Libro libro = gestor.buscarPorISBN(libros, isbn);
        System.out.println(libro != null ? libro : "No se encontro el libro"); // Si es true muestra el libro, sino el mensaje
    }



}

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    // Atributos
    Scanner sc = new Scanner(System.in);
    private ArrayList<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public void menuPrincipal() {
        int opcion;

        do {
            System.out.println("Bienvenido a la biblioteca");
            System.out.println("-----------------------------");
            System.out.println("1. Agregar un nuevo libro");
            System.out.println("2. Buscar libros por ISBN");
            System.out.println("3. Buscar libros por autor");
            System.out.println("4. Buscar libros por titulo");
            System.out.println("5. Mostrar todos los libros");
            System.out.println("6. Salir del programa");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> this.agregarLibro();
                case 2 -> this.buscarLibroISBN();
                case 3 -> this.buscarLibroAutor();
                case 4 -> this.buscarLibroTitulo();
                case 5 -> this.mostrarTotalLibros();
                case 6 -> System.out.println("Saliendo del programa...");
            }
        } while (opcion != 6);
    }

    public void agregarLibro() {
        String titulo;
        String autor;
        String ISBN;
        int fechaPublicacion;

        System.out.println("Agregar nuevo libro");
        System.out.println("---------------------");
        System.out.println("Introduce el titulo");
        titulo = sc.nextLine();
        sc.nextLine();

        System.out.println("Introduce el autor del libro");
        autor = sc.nextLine();

        System.out.println("Introduce el ISBN del libro");
        while (true) {
            ISBN = sc.nextLine();
            boolean isbnRepetido = false;

            for (Libro libro : libros) {
            if (ISBN.equals(libro.getISBN())) {
                System.out.println("Error, el ISBN debe de ser unico. Introduce otro ISBN:");
                isbnRepetido = true;
                break;
            }
            }

            if (!isbnRepetido) {
            break;
            }
        }

        System.out.println("Introduce el año de publicacion");
        fechaPublicacion = sc.nextInt();

        Libro nuevoLibro = new Libro(titulo, autor, ISBN, fechaPublicacion);
        libros.add(nuevoLibro);
        
        // TODO: Aqui iria el metodo para guardarlo en libros.txt

        System.out.println("Libro agregado exitosamente");

    }

}

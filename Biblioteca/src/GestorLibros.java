import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestorLibros {
    private static final String RUTA = "Biblioteca\\src\\libros.txt";

    public ArrayList<Libro> cargarLibros() {
        ArrayList<Libro> libros = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] campos = linea.split(";");
                if (campos.length == 4) {
                    libros.add(new Libro(campos[0], campos[1], campos[2], Integer.parseInt(campos[3])));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
        return libros;
    }

    public void guardarLibro(Libro libro) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA, true))) {
            writer.write(libro.toFileString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro al guardar el libro: " + e.getMessage());
        }
    }

    public boolean existeISBN(ArrayList<Libro> libros, String isbn) {
        for (Libro libro : libros) {
            if (libro.getISBN().equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Libro> buscarPorAutor(ArrayList<Libro> libros, String autor) {
        ArrayList<Libro> resultado = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    public ArrayList<Libro> buscarPorTitulo(ArrayList<Libro> libros, String titulo) {
        ArrayList<Libro> resultado = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    public Libro buscarPorISBN(ArrayList<Libro> libros, String isbn) {
        for (Libro libro : libros) {
            if (libro.getISBN().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }
    }



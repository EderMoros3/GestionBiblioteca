import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestorLibros {
    private static final String RUTA = "libros.txt";

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

    
}

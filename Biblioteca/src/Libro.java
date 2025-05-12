public class Libro {
    private String titulo;
    private String autor;
    private String ISBN;
    private int fechaPublicacion;

    public Libro(String titulo, String autor, String iSBN, int fechaPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = iSBN;
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }

    public void setAutor(String autor) { this.autor = autor; }

    public String getISBN() { return ISBN; }

    public void setISBN(String iSBN) { ISBN = iSBN; }

    public int getFechaPublicacion() { return fechaPublicacion; }

    public void setFechaPublicacion(int fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }

    @Override
    public String toString() {
        return  titulo +  autor + ISBN + fechaPublicacion;
    }

    

    
}

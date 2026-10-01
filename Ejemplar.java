public class Ejemplar {
    private String codigoInventario;
    private Libro libro; // Relación estructural con el libro conceptual

    public Ejemplar(String codigoInventario, Libro libro) {
        this.codigoInventario = codigoInventario;
        this.libro = libro;
    }

    public String getCodigoInventario() {
        return codigoInventario;
    }

    public Libro getLibro() {
        return libro;
    }
}
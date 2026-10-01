import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prestamo {
    private Estudiante estudiante;
    private Ejemplar ejemplar;
    private LocalDate fechaPrevistaDevolucion;
    private List<Renovacion> renovaciones; // Composición: Las renovaciones viven dentro del préstamo

    public Prestamo(Estudiante estudiante, Ejemplar ejemplar, LocalDate fechaPrevistaDevolucion) {
        this.estudiante = estudiante;
        this.ejemplar = ejemplar;
        this.fechaPrevistaDevolucion = fechaPrevistaDevolucion;
        this.renovaciones = new ArrayList<>();
    }

    public void renovar(LocalDate nuevaFecha) {
        // Regla de negocio: La implementación impide una renovación cuya nueva fecha sea igual o anterior a la vigente
        if (nuevaFecha == null || !nuevaFecha.isAfter(this.fechaPrevistaDevolucion)) {
            throw new IllegalArgumentException("Error de validación: La nueva fecha de devolución debe ser estrictamente posterior a la fecha prevista vigente (" + this.fechaPrevistaDevolucion + ").");
        }
        
        // Creamos y almacenamos la renovación en el historial interno
        Renovacion nuevaRenovacion = new Renovacion(LocalDate.now(), this.fechaPrevistaDevolucion, nuevaFecha);
        this.renovaciones.add(nuevaRenovacion);
        
        // Actualizamos la fecha prevista de devolución del préstamo
        this.fechaPrevistaDevolucion = nuevaFecha;
    }

    public LocalDate getFechaPrevistaDevolucion() {
        return fechaPrevistaDevolucion;
    }

    public int getCantidadRenovaciones() {
        return renovaciones.size();
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }
}

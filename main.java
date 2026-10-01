import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO PRUEBAS DE SMARTLIBRARY (POO) ==-\n");

        // 1. Creación de actores y catálogo
        Estudiante estudiante = new Estudiante("10098765", "Valeria Pantoja", "valeria.pantoja@correo.com", "202420", "Ingeniería de Software");
        Libro libroBase = new Libro("978-0134685991", "Clean Architecture", "Robert C. Martin");
        Ejemplar ejemplar = new Ejemplar("EJP-001", libroBase);
        
        Prestamo prestamo = new Prestamo(estudiante, ejemplar, LocalDate.of(2026, 10, 10));

        // 2. Prueba de renovación VÁLIDA
        System.out.println("--- Prueba 1: Renovación Válida ---");
        try {
            LocalDate fechaSolicitada = LocalDate.of(2026, 10, 20);
            prestamo.renovar(fechaSolicitada);
            
            // Polimorfismo y uso de contrato de interfaz
            estudiante.notificar("Su préstamo del libro '" + ejemplar.getLibro().getTitulo() + "' ha sido renovado con éxito.");
            
            System.out.println("-> Nueva fecha prevista: " + prestamo.getFechaPrevistaDevolucion());
            System.out.println("-> Total de renovaciones registradas: " + prestamo.getCantidadRenovaciones());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--------------------------------------------------\n");

        // 3. Prueba de renovación INVÁLIDA (Fecha anterior o igual a la vigente)
        System.out.println("--- Prueba 2: Renovación Inválida (Restricción de fecha) ---");
        try {
            // Intentamos renovar con fecha 15 de octubre, cuando la vigente ya es 20 de octubre
            LocalDate fechaInvalida = LocalDate.of(2026, 10, 15);
            prestamo.renovar(fechaInvalida);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada exitosamente: " + e.getMessage());
        }
    }
}

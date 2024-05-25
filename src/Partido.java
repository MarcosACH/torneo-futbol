import java.time.LocalDate;

public class Partido {
    private String nombreLocal;
    private String nombreVisitante;
    private LocalDate fecha;
    private int golesLocal;
    private int golesVisitante;

    public Partido(String nombreLocal, String nombreVisitante, LocalDate fecha, int golesLocal, int golesVisitante) {
        this.nombreLocal = nombreLocal;
        this.nombreVisitante = nombreVisitante;
        this.fecha = fecha;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", " +
                nombreLocal + "(" + golesLocal + ")" + "-" +
                nombreVisitante + "(" + golesVisitante + ")";
    }
}

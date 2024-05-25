import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Torneo {
    private ArrayList<Object> torneo;
    private Map<String, TablaEquipo> tablaEquipos;

    public Torneo() {
        torneo = new ArrayList<>();
        tablaEquipos = new HashMap<>();
    }

    public void cargarEquipo(String nombre, int fans) {
        Equipo equipo = new Equipo(nombre, fans);
        torneo.add(equipo);
        if (!tablaEquipos.containsKey(nombre)) {
            tablaEquipos.put(nombre, new TablaEquipo(nombre));
        }
    }

    public void cargarPartido(String nombreLocal, String nombreVisitante, LocalDate fecha, int golesLocal,
            int golesVisitante) {
        Partido partido = new Partido(nombreLocal, nombreVisitante, fecha, golesLocal, golesVisitante);
        torneo.add(partido);
        tablaEquipos.get(nombreLocal).actualizarEstadisticas(golesLocal, golesVisitante);
        tablaEquipos.get(nombreVisitante).actualizarEstadisticas(golesVisitante, golesLocal);
    }

    public void mostrarPartidosFecha(LocalDate fecha) {
        for (Object obj : torneo) {
            if (obj instanceof Partido) {
                Partido partido = (Partido) obj;
                if (partido.getFecha().equals(fecha)) {
                    System.out.println(partido);
                }
            }
        }
    }

    public void mostrarTabla() {
        List<TablaEquipo> listaEquipos = new ArrayList<>(tablaEquipos.values());

        listaEquipos.sort(Comparator.comparingInt(TablaEquipo::getPuntos)
                .thenComparingInt(TablaEquipo::getDiferenciaGoles)
                .reversed());

        System.out.println("Equipo | Ju | Pu | Ga | Em | Pe | GF | GC | DG");
        for (TablaEquipo tablaEquipo : listaEquipos) {
            System.out.println(tablaEquipo);
        }
    }

    @Override
    public String toString() {
        return "Torneo{" + torneo + "}";
    }
}

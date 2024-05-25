public class TablaEquipo {
    private String nombre;
    private int partidosJugados;
    private int puntos;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;
    private int golesConvertidos;
    private int golesRecibidos;

    public TablaEquipo(String nombre) {
        this.nombre = nombre;
    }

    public void actualizarEstadisticas(int golesFavor, int golesContra) {
        partidosJugados++;
        golesConvertidos += golesFavor;
        golesRecibidos += golesContra;
        if (golesFavor > golesContra) {
            partidosGanados++;
            puntos += 3;
        } else if (golesFavor == golesContra) {
            partidosEmpatados++;
            puntos += 1;
        } else {
            partidosPerdidos++;
        }
    }

    public int getPuntos() {
        return puntos;
    }

    public int getDiferenciaGoles() {
        return golesConvertidos - golesRecibidos;
    }

    @Override
    public String toString() {
        return String.format("%-2s | %d | %d | %d | %d | %d | %d | %d | %d",
                nombre, partidosJugados, puntos, partidosGanados, partidosEmpatados, partidosPerdidos,
                golesConvertidos, golesRecibidos, getDiferenciaGoles());
    }
}

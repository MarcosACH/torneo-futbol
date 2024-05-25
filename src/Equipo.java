public class Equipo {
    private String nombre;
    private int fans;

    public Equipo(String nombre, int fans) {
        this.nombre = nombre;
        this.fans = fans;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", fans=" + fans;
    }
}

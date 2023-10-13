public class Tutor {
    String nombre;
    String edad;
    Telefono telefono = new Telefono();

    public Tutor(String nombre, String edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Tutor() {
        this("Juan", "30");
    }

    public String getTutor() {
        return nombre + " " + edad;
    }
    
}

public class Alumno {
    String nombre;
    String carrera;
    String matricula;
    String grado;
    String grupo;
    Tutor tutor = new Tutor();
    public String  telefono;
    public Alumno( String nombre, String carrera, 
    String matricula, String grado, String grupo) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.matricula = matricula;
        this.grado = grado;
        this.grupo = grupo;
        tutor = new Tutor();
    }

    public Alumno() {
        this("Josue", "ISC", "70700", "2do", "b");
    }

    public String getAlumno() {
        return "Alumno: " + nombre + " " + carrera + " " + matricula + " " + grado + " " + grupo;
    }

    @Override
    public String toString() {
        return "Alumno [nombre=" + nombre + ", carrera=" + carrera + ", matricula=" + matricula + ", grado=" + grado
                + ", grupo=" + grupo + ", tutor=" + tutor + ", telefono=" + telefono + "]";
    }
    
    
}
public class TesterEncadenamiento {
    public static void main(String[] args) {
        Alumno alumno = new Alumno();
        System.out.println(alumno.getAlumno().toString());
        System.out.println(alumno.tutor.getTutor().toString());
        System.out.println(alumno.tutor.telefono.getTelefono().toString());

    }
}

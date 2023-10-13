public class Telefono {

    String pais;
    String lada;
    String numero;

    public Telefono(String pais, String lada, String numero) {
        this.pais = pais;
        this.lada = lada;
        this.numero = numero;
    }

    public Telefono() {
        this("52", "982", "1255354");
    }

    public String getTelefono() {
        return "Telefono: " + pais + "" + lada + "" + numero;
    }

}
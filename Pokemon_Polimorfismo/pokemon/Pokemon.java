public interface Pokemon {
    String getNombre();
    int getPs();
    int getAtaque();
    int getDefensa();
    int getAtaqueEspecial();
    int getDefensaEspecial();
    Double getVelocidad();
    int getNivel();
    Tipo getTipo1();
    Tipo getTipo2();
    String getClase();
    void setClase(String clase);
    void recibirDanio(int danio);
    double calcularDanio(double efectividad, double variacion, int nivel, int ataque, int defensa, Pokemon pokemon);
    int calcularVida(int ps);

}

import java.util.Random;

public class Lanturn extends PokemonDosTipos implements Pokemon {

    private double danio;

    public Lanturn(String nombre, int ps, int ataque, int defensa, int ataqueEspecial, int defensaEspecial, double velocidad, int nivel, Tipo tipo1, Tipo tipo2, String clase) {
        super(nombre, ps, ataque, defensa, ataqueEspecial, defensaEspecial, velocidad, nivel, tipo1, tipo2, clase);
    }

    @Override
    public int getAtaqueEspecial() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getAtaque() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public int getDefensa() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getDefensaEspecial() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getNombre() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double getVelocidad() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getPs() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getNivel() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Tipo getTipo1() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Tipo getTipo2() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getClase() {
        // TODO Auto-generated method stub
        return super.getClase();
    }

    public void recibirDanio(int danio) {
        double puntosRestados = this.getPs() - danio; 
    }
    

    public double calcularDanio(double efectividad, double variacion, int nivel, int ataque, int defensa, Pokemon pokemon) {
            // TODO Auto-generated method stub
            Random random = new Random();
            variacion = (random.nextInt(16) + 85);
            danio = (((0.2 * nivel + 1)*(this.getAtaqueEspecial()))/(25 * defensa)) +1; 

            return danio;
        }

    public int calcularVida(int ps) {
        double vida = (ps - danio);
        return  (int)vida;
    }


}


import java.util.Random;

public abstract class PokemonDosTipos implements Pokemon{

    private String nombre;
    private int ps, ataque, defensa, ataqueEspecial, defensaEspecial;
    private double velocidad;
    private int nivel;
    private Tipo tipo1;
    private Tipo tipo2;
    private String clase;
    private double danio;

    public PokemonDosTipos(String nombre, int ps, int ataque, int defensa, int ataqueEspecial, int defensaEspecial, double velocidad, int nivel, Tipo tipo1, Tipo tipo2, String clase) {
        this.nombre = nombre;
        this.ps = ps;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        this.nivel = nivel;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.clase = clase;
    }

    @Override
    public String getClase() {
        // TODO Auto-generated method stub
        return this.clase;
    }
    @Override
    public void setClase(String clase) {
        // TODO Auto-generated method stub
        
    }

        @Override
        public abstract void recibirDanio(int danio);
        @Override
        public abstract double calcularDanio(double efectividad, double variacion, int nivel, int ataque, int defensa, Pokemon pokemon);

        @Override
        public abstract int calcularVida(int ps);

    }

public class Pokemon {
    private int hp;
    private int nivel;
    private String nombre;
    private String tipo;

    public Pokemon(int nivel, String nombre, String tipo) {
        this.hp = 100;
        this.nivel = nivel;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getHp() {
        return hp;
    }

    public int getNivel() {
        return nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int calculaDanio(int danio){
        this.hp -= danio;
        System.out.printf("%s recibe %d puntos de danio\n", this.getNombre(),danio);
        return danio;
    }
    public void recibirAtaque(String movimiento) {
        System.out.printf("%s Recibe ATK %s\n", this.getNombre(), movimiento);
        int vida = this.hp - calculaDanio((int) (Math.random() * 10 + 1));
        System.out.printf("%s tiene ahora %d puntos de vida\n", this.getNombre(), vida);
    }
    public void atacar(String movimiento, Pokemon pokemon) {
        System.out.printf("%s ataca a %s con %s\n", this.getNombre(), pokemon.getNombre(),
                movimiento);
        pokemon.recibirAtaque(movimiento);
    }

}
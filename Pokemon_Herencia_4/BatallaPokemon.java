public class BatallaPokemon {
    public static void main(String[] args) {
        PokemonFuego dragon = new PokemonFuego(10, "Charizard", "dragon");
        PokemonAgua agua = new PokemonAgua(10, "Squirtle", "agua");

        dragon.atacar("tiro de fuego", agua);
        agua.atacar("rayo", dragon);
    }
}
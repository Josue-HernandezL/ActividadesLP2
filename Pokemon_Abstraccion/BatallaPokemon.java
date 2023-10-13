import pokemon.PokemonAgua;
import pokemon.PokemonFuego;

public class BatallaPokemon {
    public static void main(String[] args) {
        PokemonFuego Charizard = new PokemonFuego("Charizard", 10);
        PokemonAgua Squirtle = new PokemonAgua("Squirtle", 10);

        Charizard.atacar(3, Squirtle);
        Squirtle.atacar(2, Charizard);
    }
}
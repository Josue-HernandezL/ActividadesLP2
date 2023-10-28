import pokemon.Charizard;
import pokemon.Lanturn;
import pokemon.Pokemon;
import pokemon.Tipo;

public class BatallaPokemon {
    public static void main(String[] args) throws Exception {
        Pokemon charizard = new Charizard("Charizard", 100, 20, 100, 20, 30, 25.6, 10, Tipo.FUEGO, Tipo.VOLADO, "Fisico");

        Pokemon lanturn = new Lanturn("Lanturn", 100, 20, 100, 20, 30, 25.6, 10, Tipo.AGUA, Tipo.ELECTRICO, "Especial");
    }
}
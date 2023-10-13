public class PokemonFuego extends Pokemon{

    public PokemonFuego(String nombre, int nivel) {
        super(nivel, nombre, Tipo.FUEGO);

        ListaMovimientos listaMovimientos = new ListaMovimientos();

    setMovimiento(0, listaMovimientos.buscarMovimientoPorNombre("Anillo ígneo"));
    setMovimiento(1, listaMovimientos.buscarMovimientoPorNombre("Ascuas"));
    setMovimiento(2, listaMovimientos.buscarMovimientoPorNombre("Terra temblor"));
    setMovimiento(3, listaMovimientos.buscarMovimientoPorNombre("Meteoros"));
    }


    
    @Override
    public double obtenerEfectividad (Pokemon pokemon) {
        double efectividad = 1.0;

        if(pokemon.getTipo() == Tipo.ACERO) efectividad = 2.0;
        if(pokemon.getTipo() == Tipo.AGUA) efectividad = 0.5;
        if(pokemon.getTipo() == Tipo.BICHO) efectividad = 2.0;
        if(pokemon.getTipo() == Tipo.DRAGON) efectividad = 0.5;
        if(pokemon.getTipo() == Tipo.FUEGO) efectividad = 0.5;
        if(pokemon.getTipo() == Tipo.HIELO) efectividad = 2.0;
        if(pokemon.getTipo() == Tipo.PLANTA) efectividad = 2.0;
        if(pokemon.getTipo() == Tipo.ROCA) efectividad = 0.5;

        return efectividad;
    }
}